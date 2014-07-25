grails-mobile-notification-sandbox
==================================

Simple demostration of Grails accessing mobile infraestructure


Servicios que permiten la suscripcion de un dispositivo tipo android, y el envio de un mensaje a todos los sucriptos.

La suscripcion se realiza por medio del DeviceController, Lo unico que hace este es recibir el deviceToken y guardarlo

El envio del mensaje se hace por medio de un POST request, en el SendNotificationController.

Se envia la informacion necesaria para que se muestre una notificacion con titulo y mensaje, siguiendo las especificaciones de android(http://developer.android.com/google/gcm/server.html), para un mensaje de texto plano (un mensaje de tipo JSON varia), y lo requerido por el plugin de cordova PushPlugin