package cn.stormsend.capacitor.plugins.proj4j;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.ProjCoordinate;

@CapacitorPlugin(name = "Proj4j")
public class Proj4jPlugin extends Plugin {

    private Proj4jComponent component;

    public static final String EPSG_PREFIX = "EPSG:";


    @Override
    public void load() {
        super.load();
        component = new Proj4jComponent();

    }

    @PluginMethod
    public void transform(PluginCall call) {
        String targetCrs = call.getString("targetCrs");
        String sourceCrs = call.getString("sourceCrs");
        assert targetCrs != null;
        assert sourceCrs != null;
        if (!targetCrs.startsWith(EPSG_PREFIX) || !sourceCrs.startsWith(EPSG_PREFIX)) {
            call.reject("原始和目标坐标系必须以 EPSG: 命名");
            return;
        }
        ProjCoordinate projCoordinate = new ProjCoordinate();
        try {
            JSObject coordinate = call.getObject("coordinate");
            projCoordinate = component.transform(sourceCrs, targetCrs, new ProjCoordinate(coordinate.getDouble("x"),
                    coordinate.getDouble("y")));
        } catch (Exception e) {
            call.reject("Proj4j transforms failed", e);
        }
        call.resolve(new JSObject().put("x", projCoordinate.x).put("y", projCoordinate.y));
    }
}
