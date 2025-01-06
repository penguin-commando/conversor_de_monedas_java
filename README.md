# conversor_de_monedas_java

# Conversor de Monedas

## Descripción

Este programa en Java permite convertir valores de diferentes monedas utilizando tasas de cambio obtenidas desde una API externa en tiempo real. Ofrece un menú interactivo que permite al usuario actualizar las tasas de cambio y realizar conversiones entre diversas monedas. Este programa hace uso de la API de `exchangerate-api.com`, que proporciona tasas de cambio actualizadas desde una moneda base (USD en este caso).

## Funcionalidades

1. **Actualizar tasas de cambio**: El programa obtiene las tasas de cambio más recientes desde la API y las guarda en la memoria local.
2. **Convertir moneda**: El usuario puede ingresar una cantidad en una moneda de origen y el programa devolverá el equivalente en la moneda de destino utilizando las tasas de cambio actuales.
3. **Salir**: Termina la ejecución del programa.

## Requisitos

- **Java 11 o superior**: Este proyecto está basado en Java 11 o versiones más recientes.
- **Conexión a Internet**: Se requiere para acceder a la API externa y obtener las tasas de cambio.
- **API Key de ExchangeRate API**: Necesitarás una clave de API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio. La clave debe ser insertada en el archivo `APIHandler.java`.

## Estructura del Proyecto

El proyecto está compuesto por tres clases principales:

1. **ConversorMonedas.java**: Esta es la clase principal que maneja el flujo de interacción con el usuario a través de un menú de opciones. Controla las elecciones del usuario, como actualizar las tasas de cambio, realizar conversiones y salir del programa.
2. **ConversionHandler.java**: Clase encargada de manejar las conversiones de moneda. Recibe las tasas de cambio de la clase `APIHandler` y realiza las conversiones cuando el usuario ingresa las monedas y la cantidad a convertir.
3. **APIHandler.java**: Esta clase se encarga de gestionar las solicitudes a la API externa para obtener las tasas de cambio más recientes. La clave de la API debe ser proporcionada aquí para autenticar las solicitudes.

### Diagrama de flujo general del programa:

1. **ConversorMonedas.java**:
   - Muestra el menú de opciones.
   - Si el usuario elige **Actualizar tasas de cambio**, invoca `apiHandler.actualizarTasas()`.
   - Si elige **Convertir moneda**, invoca `conversionHandler.realizarConversion()`.
   - Si elige **Salir**, termina la ejecución del programa.

2. **ConversionHandler.java**:
   - Verifica si las tasas de cambio están actualizadas.
   - Si están disponibles, solicita al usuario las monedas de origen y destino, así como la cantidad a convertir.
   - Realiza el cálculo utilizando las tasas de cambio y muestra el resultado.

3. **APIHandler.java**:
   - Envía una solicitud HTTP a la API de `exchangerate-api.com`.
   - Si la respuesta es exitosa, guarda las tasas de cambio.
   - Si la solicitud falla, maneja el error adecuadamente.

## Uso

### 1. Ejecución del programa

Para ejecutar el programa, abre la terminal o el IDE de tu preferencia y corre el siguiente comando en el directorio donde se encuentran los archivos `.java`:

```bash
javac ConversorMonedas.java ConversionHandler.java APIHandler.java
java ConversorMonedas


El programa mostrará un menú en consola con tres opciones principales:

1) Actualizar tasas de cambio: Al seleccionar esta opción, el programa obtendrá las tasas de cambio más recientes de la API y las almacenará en la memoria para usarlas en conversiones futuras.
2) Convertir moneda: Permite ingresar una moneda de origen, una moneda de destino y la cantidad a convertir. El programa luego calculará y mostrará el valor convertido.
3) Salir: Finaliza el programa.

Es importante considerar la API key, se incluyó una pero si llega a dejar de ser válida, se dejó comentada una alternativa sin APIkey


## Dependencias
Gson: Se utiliza para parsear la respuesta JSON de la API.
Exchange-rate: proveedor de las tasas de cambio a través del API
