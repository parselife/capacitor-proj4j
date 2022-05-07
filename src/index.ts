/*
 * @Author: alex
 * @Date: 2022-04-28 10:43:22
 * @LastEditTime: 2022-04-28 11:16:40
 * @LastEditors: alex
 */
import { registerPlugin } from '@capacitor/core';

import type { Proj4jPlugin } from './definitions';

const MyProj4jPlugin = registerPlugin<Proj4jPlugin>('Proj4jPlugin', {
  web: () => import('./web').then(m => new m.Proj4jPluginWeb()),
});

export * from './definitions';
export { MyProj4jPlugin };
