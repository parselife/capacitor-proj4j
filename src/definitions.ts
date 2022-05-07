/*
 * @Author: alex
 * @Date: 2022-04-28 10:43:22
 * @LastEditTime: 2022-04-28 16:40:27
 * @LastEditors: alex
 */
export interface Proj4jPlugin {
   
  /**
   * 转换坐标
   * @param options {@link TransformOptions}
   */
  transform(options: TransformOptions): Promise<{ x: number,y: number }>;
}

export interface TransformOptions {
  
  /**
   * 源crs
   * eg: `EPSG: 3857`
   */
  sourceCrs: string,

  /**
   * 目标crs
   * eg: `EPSG:4326`
   */
  targetCrs: string,

  /**
   * 需要转换的坐标点
   */
  coordinate: Coordinate,
}

export interface Coordinate {

  /**
   * x
   */
  x: number,

  /**
   * y
   */
  y: number
}
