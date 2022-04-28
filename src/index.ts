import { registerPlugin } from '@capacitor/core';

import type { Proj4jPluginPlugin } from './definitions';

const Proj4jPlugin = registerPlugin<Proj4jPluginPlugin>('Proj4jPlugin', {
  web: () => import('./web').then(m => new m.Proj4jPluginWeb()),
});

export * from './definitions';
export { Proj4jPlugin };
