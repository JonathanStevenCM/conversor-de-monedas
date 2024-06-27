# Conversor de monedas sencillo
![logoProyecto](https://github.com/JonathanStevenCM/conversor-de-monedas/assets/74932904/2967a5c3-cd40-47d2-b188-466042206d3d)

Es un conversor de monedas consumiendo la api de ExchangeRate,
la cual nos permite obtener la cotización de una moneda respecto a otra.

Decidí utilizar la api de ExchangeRate por su facilidad de uso y sobre 
por la opcion de Pair Conversion Requests que permite obtener la conversión
de manera sencilla solo haciendo una solicitud request.

Uno de los problemas que me surgieron es la dificultad, aunque sencilla de 
solucionar, de guardar el dato de la conversión pero lo solucione utilizando
un @SelializeName("") de la libreria GSON.

## Como usar el programa

Primero ingresaremos nuestra clave para utilizar la api en la antepenultima linea 
de codigo.

![muestra de donde colocar la apikey](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/key.png)

Despues ejecutaremos el codigo nos aparecerá unas lineas de codigo en la terminal
selecciona un numero del 1 al 6.
![Muestra de seleccionarpares](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/seleccionarConversion.png)

Por ultimo agrega la cantidad de dinero que quieres convertir en la otra moneda.

![Muestra colocar cantidad a convertir](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/cantidadAConvertir.png)

Y tatan!!!, devolverá conversion y se ejecutara otra vez el codigo, 
hasta que selecciones el número 6 de salir.

![Muestra del desarrollo](https://github.com/JonathanStevenCM/conversor-de-monedas/blob/master/imagenes/muestraDelConversor.png)

## Partes del codigo

### Codigo Main
Lo primero que hice fue crear mi main en la clase llamada Principal, 
despues inicie un Scaner y cree un bucle con la propieda true.
```public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        while (true) {
```

Dentro del bucle primero cree las variables necesarias para la ejecución
del codigo, un objeto de clase Monedas llamado divisa que será el que ejecutara 
el metodo para la conversion de las divisas y despues imprimi 
diversas Strings con el System.out.println(), y al final agrege un nextLine()
a una variable busqueda que se encargara de guardar el número que el 
usuario seleccione para la conversion.

```
            String divisa1 = "";
            String divisa2 = "";
            String key;
            Double monto;
            Monedas divisa = new Monedas();

            // Formato de selección
            System.out.println("*************************************");
            System.out.println("Ingresa la conversion que deseas, seleccionado un numero del 1 al 6:");
            System.out.println("1. EUR a USD");
            System.out.println("2. AUD a USD");
            System.out.println("3. USD a GBP");
            System.out.println("4. USD a JPY");
            System.out.println("5. USD a CAD");
            System.out.println("6. Salir");
            System.out.println("*************************************");

            var busqueda = lectura.nextLine();
```
En la parte de abajo de mis SOUT cree un switch-case para validar el número que 
selecciono el usuario y que asigne los valores a las variables divisa con 
las que se trabajara la conversion conversion de monedas que el usuario selecciono.

```
            // Mecanismo de selección de conversión
            switch (busqueda) {
                case "1":
                    divisa1 = "EUR";
                    divisa2 = "USD";
                    break;
                case "2":
                    divisa1 = "AUD";
                    divisa2 = "USD";
                    break;
                case "3":
                    divisa1 = "USD";
                    divisa2 = "GBP";
                    break;
                case "4":
                    divisa1 = "USD";
                    divisa2 = "JPY";
                    break;
                case "5":
                    divisa1 = "USD";
                    divisa2 = "CAD";
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
```
Despues de lo anterior solo coloqué un if con la condicion que si las 2
variables divisas estan vacias se ejecute un break y finalize el programa.
Ya en la recta final solo cree un Scaner que guardara la cantidad de dinero
que el usuario decidira convertir, dicha cantidad se guardara en una variable 
llamada monto.
```
            if (divisa1 == "" || divisa2 == "") {
                break;
            }

            Scanner dinero = new Scanner(System.in);

            System.out.println("Ingrese la cantidad de " + divisa1 + " que quieres convertir a " + divisa2 + " :");
            monto = dinero.nextDouble();
```
Ya para el final solo sobreescribi la variable Key con mi llave de la api 
ExchangeRate y ejecuté el objeto divisa y le asigne el metodo conversion()
con los devidos valores que pide el metodo, ademas de cerrar las llaves del programa. 

```
            // Clave para que funcione la api.
            key = "Escribe tu clave de la Api ExchangeRate";

            // Metodo conversion del objeto Monedas llamado divisa
            divisa.conversion(divisa1, divisa2, monto, key);
        }
    }
}
```

### Clase Monedas

En la clase que cree para este challegen del programa One de Oracle junto a AluraLATAM
, la clase Monedas es la que contiene la conexión hacia el servidor mediante un metodo 
HttpRequest y tambien un HttpRequest despues se transforma a json por mecanismo 
de la libreira Gson, todo lo anterior dentro del metodo .conversion(), el metodo conversion
tambien genera un objeto tipo Monedas el cual se encarga de devolver exactamente 
la converision de las monedas seleccionadas me diante el toString de la 
clase Monedas.

```
public class Monedas {
    // Etiqueta que selecciona la variable que guaradará el valor de la conversión
    @SerializedName("conversion_result")
    private Double conversion;

    public Monedas() {

    }

    // Metodo de generar la conversión de las divisas.
    public static void conversion(String moneda1, String moneda2, Double cantidad, String key)
            throws IOException, InterruptedException {
        try {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting()
                    .create();

            // Mecanismo automatico de conversion proporcionado por la api de ExchangeRate.
            String direccion = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + moneda1 + "/" + moneda2 + "/"
                    + cantidad;

            // Conección con la base de datos
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            final HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            // Transformacion del json a objeto Monedas
            Monedas moneResul = gson.fromJson(json, Monedas.class);
            // Imprecion de la conversión de las monedas ´+ su denominación
            System.out.println(moneResul + " " + moneda2);

        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e.getCause());
        }

    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    @Override
    public String toString() {
        return "Este es el resultado de su conversion = " + conversion;
    }
}


```
