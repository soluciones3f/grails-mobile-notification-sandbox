package androidpush

import grails.converters.JSON

class SendNotificationController {

    def redisService

    def sendMessage () {
        def devices = redisService.smembers("devices:android")

        for(device in devices){
            withHttp(uri: "https://android.googleapis.com/gcm/") {
                def bodyContent = [
                       registration_id: device,
                       data: "{'message':'Hola','msgcnt':'1'}",
                       message:'Hola',
                       msgcnt: '1'
                    ]
                def json = post(path: 'send', 
                    body: bodyContent, 
                    headers:['Authorization':'key=AIzaSyC-jnkrWsZq8BL32KMjiOJBHNxRjNTpHk8',
                        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'])
                println json
            }
        }
        render ""
    }
}