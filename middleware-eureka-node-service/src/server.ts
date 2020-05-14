import { ServerLoader, ServerSettings, GlobalAcceptMimesMiddleware } from "@tsed/common";
import * as config from 'config';

const bodyParser = require("body-parser");
const cookieParser = require("cookie-parser");
const cors = require("cors");
export const rootDir = __dirname;



@ServerSettings({
  version: config.get("info.dhr.version.back-end"),
  rootDir,
  port: config.get("app.port"),
  host: config.get("app.expose-host"),
  debug: true,
  logger: {
    level: "info",
    debug: false,
    logRequest: false,
    requestFields: ["reqId", "method", "url", "headers", "query", "params", "duration"]
  },
  acceptMimes: ["application/json", "multipart/form-data"],
  mount: {
    "/api": [
      `${rootDir}/api/**/*.controller.ts`,
      `${rootDir}/api/**/*.controller.js`
    ]
  },
  componentsScan: [
    `${rootDir}/middleware/**/*.middleware.ts`,
    `${rootDir}/middleware/**/*.middleware.js`,
    `${rootDir}/repository/**/*.repository.ts`,
    `${rootDir}/repository/**/*.repository.js`,
    `${rootDir}/service/**/*.service.ts`,
    `${rootDir}/service/**/*.service.js`    
  ]
})
export class Server extends ServerLoader {

  /**
   * This method let you configure the express middleware required by your application to works.
   * @returns {Server}
   */
  public $onMountingMiddlewares(): void|Promise<any> {
      this
        .use(GlobalAcceptMimesMiddleware)
        .use(cors())
        .use(cookieParser())
        .use(bodyParser.json())
        .use(bodyParser.urlencoded({
          extended: true
        }));

      return null;
  }
}
