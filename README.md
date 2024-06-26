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
![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/seleccionarConversion.png)

Por ultimo agrega la cantidad de dinero que quieres convertir en la otra moneda.

![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/cantidadAConvertir.png)

Y tatan!!!, devolverá conversion y se ejecutara otra vez el codigo, 
hasta que selecciones el número 6 de salir.

![alt text](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/muestraDelConversor.png)

## Partes del codigo


Lo primero que hice fue crear mi main en la clase llamada Principal, 
despues inicie un Scaner y cree un bucle con la propieda true.
```public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        while (true) {```
Dentro del bucle primero cree las variables necesarias para la ejecución
del codigo, un objeto de clase Monedas llamado divisa que será el que ejecutara 
el metodo para la conversion de las divisas y despues imprimi 
diversas Strings con el System.out.println(), y al final agrege un nextLine()
a una variable busqueda que se encargara de guardar el número que el 
usuario seleccione para la conversion.
En la parte de abajo de mis SOUT cree un switch-case para validar el número que 
selecciono el usuario y que asigne los valores a las variables divisa con 
las que se trabajara la conversion conversion de monedas que el usuario selecciono.
Despues de lo anterior solo coloqué un if con la condicion que si las 2
variables divisas estan vacias se ejecute un break y finalize el programa.
Ya en la recta final solo cree un Scaner que guardara la cantidad de dinero
que el usuario decidira convertir, dicha cantidad se guardara en una variable 
llamada monto.
Ya para el final solo sobreescribi la variable Key con mi llave de la api 
ExchangeRate y ejecuté el objeto divisa y le asigne el metodo conversion()
con los devidos valores que pide el metodo. 

