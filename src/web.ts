/*
 * web端使用 proj4js 实现转换
 * 
 * @Author: alex
 * @Date: 2022-04-28 10:43:22
 * @LastEditTime: 2022-04-28 18:20:04
 * @LastEditors: alex
 */
import { WebPlugin } from '@capacitor/core';
import proj4 from 'proj4';

import type { Proj4jPlugin, TransformOptions } from './definitions';

export class Proj4jPluginWeb extends WebPlugin implements Proj4jPlugin {

  /**
   * 转换坐标点
   * @param options {@link TransformOption}
   */
  transform(options: TransformOptions): Promise<{
    x: number; y: number;
  }> {
    proj4("","")

    console.log(options);
    throw new Error('Method not implemented.');
  }
}
