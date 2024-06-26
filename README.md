# Conversor de monedas sencillo

Es un conversor de monedas consumiendo la api de ExchangeRate,
la cual nos permite obtener la cotización de una moneda respecto a otra.

Decidí utilizar la api de ExchangeRate por su facilidad de uso y sobre 
por la opcion de Pair Conversion Requests que permite obtener la conversión
de manera sencilla solo haciendo una solicitud request.

Uno de los problemas que me surgieron es la dificultad, aunque sencilla de 
solucionar, de guardar el dato de la conversión pero lo solucione utilizando
un @SelializeName("") de la libreria GSON.

## Uso

Primero ingresaremos nuestra clave para utilizar la api.

![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/key.png)

