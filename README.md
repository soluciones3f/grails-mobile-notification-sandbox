grails-mobile-notification-sandbox
==================================

Simple demostration of Grails accessing mobile infraestructure

### Description 

Esta App se propone como objeto:
 * Recibir la subscripción de los dispositivos Android.
 * Enviar mensajes a los subscriptos
 * 
 
### Core

Está desarrollada usando:
 * Grails 2.4.2
 * redis services

## Métodos

### Subscripción
 
El [DeviceController](grails-app/controllers/androidpush/DeviceController.groovy) recibe el deviceToken y lo resguarda para luego usarlo al momento de notificar.

### Envío de mensajes
A través de *POST* request, en el [SendNotificationController](grails-app/controllers/androidpush/SendNotificationController.groovy).

#### Detalle sobre el mensaje
La informacion necesaria para que se muestre una notificacion con titulo y mensaje, siguiendo las [especificaciones de android](http://developer.android.com/google/gcm/server.html), para un mensaje de texto plano (un mensaje de tipo JSON varia), y lo requerido por el plugin de cordova [PushPlugin](link).

```
'Authorization':'key=AIzaSyC-jnkrWsZq8BL32KMjiOJBHNxRjNTpHk8'
```

es el APIKey se genera desde la [página de Android](https://console.developers.google.com/project).
