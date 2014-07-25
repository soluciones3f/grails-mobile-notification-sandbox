grails-mobile-notification-sandbox
==================================

Simple demostration of Grails accessing mobile infraestructure

### Description 

Esta App se propone como objeto:
 * Recibir la subscripción de los dispositivos Android.
 * Enviar mensajes a los subscriptos
 
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
La informacion necesaria para que se muestre una notificacion con titulo y mensaje, siguiendo las [especificaciones de android](http://developer.android.com/google/gcm/server.html), para un mensaje de texto plano (un mensaje de tipo JSON varia):

texto plano:
```javascript
{
    registration_id: deviceToken,
    data.<key>: value, // diccionario que contiene la informacion que llega al dispositivo
}
```
JSON
```javascript
{
    registration_ids: devicesToken, //se puede enviar hasta 1000 dispositivos simultaneamente
    data: JSON obj, // diccionario que contiene la informacion que llega al dispositivo
}
```

Y lo requerido por el plugin de cordova [PushPlugin](https://github.com/phonegap-build/PushPlugin).

```javascript
{
    data.message: ""//mensaje de la notificacion
    data.title: ""//titulo de la notificacion
}
```


El *POST* debe ser enviado con dos headers:
```
'Authorization':'key=APIKey'
'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'//para texto plano
'Content-Type': 'application/json'//para JSON
```

es el APIKey se genera desde la [página de Android](https://console.developers.google.com/project).
