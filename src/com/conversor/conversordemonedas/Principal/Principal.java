package com.conversor.conversordemonedas.Principal;

import java.io.IOException;
import java.util.Scanner;

import com.conversor.conversordemonedas.Modulos.Monedas;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        while (true) {
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

            if (divisa1 == "" || divisa2 == "") {
                break;
            }

            Scanner dinero = new Scanner(System.in);

            System.out.println("Ingrese la cantidad de " + divisa1 + " que quieres convertir a " + divisa2 + " :");
            monto = dinero.nextDouble();
            
            // Clave para que funcione la api.
            key = "Escribe tu clave de la Api ExchangeRate";

            // Metodo conversion del objeto Monedas llamado divisa
            divisa.conversion(divisa1, divisa2, monto, key);
        }
    }
}