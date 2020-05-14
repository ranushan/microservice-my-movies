import { Service } from "@tsed/common";
import * as config from 'config';

import { Eureka } from 'eureka-js-client';

@Service() 
export class EurekaService {    
   
  constructor() { }  

  private static _client: any = null;

  public static async getClient() : Promise<Eureka> {

    if(!this._client) {
      this._client = new Eureka(config.get("eureka.eureka-config"));
    }

    return this._client;  
  }

}