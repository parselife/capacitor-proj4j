package cn.stormsend.capacitor.plugins.proj4j;

import android.util.Log;

import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.Proj4jException;
import org.locationtech.proj4j.ProjCoordinate;

public class Proj4jComponent {

    private static final CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
    private static final CRSFactory csFactory = new CRSFactory();
    final String WGS84_PARAM = "+title=long/lat:WGS84 +proj=longlat +ellps=WGS84 +datum=WGS84 +units=degrees";

    public Proj4jComponent() {
    }

    /**
     * 转换坐标到 wgs84
     *
     * @param sourceCrsName 原始坐标系名称 eg: EPSG:4490
     * @param coordinate    坐标点
     * @return wgs84坐标点
     */
    public ProjCoordinate transformToWGS84(String sourceCrsName, ProjCoordinate coordinate) throws Exception {

        /*
         * Create {@link CoordinateReferenceSystem} & CoordinateTransformation.
         * Normally this would be carried out once and reused for all transform ations
         */
        CoordinateReferenceSystem crs = csFactory.createFromName(sourceCrsName);
        CoordinateReferenceSystem WGS84 = csFactory.createFromParameters("WGS84", WGS84_PARAM);
        CoordinateTransform trans = ctFactory.createTransform(WGS84, crs);
        ProjCoordinate p2 = new ProjCoordinate();
        try {
            trans.transform(coordinate, p2);
        } catch (Proj4jException e) {
            throw new Exception(e);
        }
//        Log.i("Echo", wkid);
        return p2;
    }

    /**
     * 自定义转换坐标系
     * @param sourceCrsName   源坐标系
     * @param targetCrsName   目标坐标系
     * @param coordinate
     * @return
     */
    public ProjCoordinate transform(String sourceCrsName, String targetCrsName, ProjCoordinate coordinate) throws Exception {
        CoordinateReferenceSystem srcCrs = csFactory.createFromName(sourceCrsName);
        CoordinateReferenceSystem targetCrs = csFactory.createFromName(targetCrsName);
        CoordinateTransform trans = ctFactory.createTransform(srcCrs, targetCrs);
        ProjCoordinate p2 = new ProjCoordinate();
        try {
            trans.transform(coordinate, p2);
        } catch (Proj4jException e) {
            throw new Exception(e);
        }
        return p2;
    }
}
