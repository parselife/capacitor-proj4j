import { WebPlugin } from '@capacitor/core';

import type { Proj4jPluginPlugin } from './definitions';

export class Proj4jPluginWeb extends WebPlugin implements Proj4jPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
