package androidpush

import grails.converters.JSON

class DeviceController {

    def redisService

    def subscribe () {
        log.info("hola")
        println("hola")
        if (params.deviceToken) {
            redisService.sadd("devices:android", params.deviceToken)

            //new Device(token:params.deviceToken, projectId:params.projectId).save(failOnError:true)
        }
        render ""
    }
}