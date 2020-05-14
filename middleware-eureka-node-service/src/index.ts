import { $log } from "ts-log-debug";
import { Server } from "./server";
import { EurekaService } from '@service/eureka';


new Server().start()
  .then(() => {
    $log.info("Server started...");
    EurekaService.getClient().then(e => e.start()).catch(e => { console.log(e); EurekaService.getClient().then(e => e.stop())});
  })
  .catch((err) => {
    $log.error(err);
  })