export interface Proj4jPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
