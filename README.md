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

Primero ingresaremos nuestra clave para utilizar la api en la antepenultima linea 
de codigo.

![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/key.png)

Despues ejecutaremos el codigo nos aparecerá unas lineas de codigo en la terminal
selecciona un numero del 1 al 6.
![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/key.png)

Por ultimo agrega la cantidad de dinero que quieres convertir en la otra moneda.

![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/seleccionaLaCantidad.png)

Y tatan!!!, devolverá conversion y se ejecutara otra vez el codigo.

