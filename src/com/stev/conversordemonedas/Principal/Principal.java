package com.stev.conversordemonedas.Principal;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stev.conversordemonedas.Modulos.Monedas;
import com.stev.conversordemonedas.Modulos.MonedasConvertidas;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        
        
        while(true){
            String divisa1;
            String divisa2;



            System.out.println("*************************************");
            System.out.println("Ingresa la conversion que deseas");
            System.out.println("1. EUR a USD");
            System.out.println("2. AUD a USD");
            System.out.println("3. USD a GBP");
            System.out.println("4. USD a JPY");
            System.out.println("5. USD a CAD");
            System.out.println("6. Salir");
            System.out.println("*************************************");

            var busqueda = lectura.nextLine();
            
            
            if (busqueda.equals("1")) {
                divisa1= "EUR";
                divisa2= "USD";
            } else if (busqueda.equals("2")) {
                divisa1= "AUD";
                divisa2= "USD";
            } else if (busqueda.equals("3")) {
                divisa1= "USD";
                divisa2= "GBP";
            } else if (busqueda.equals("4")) {
                divisa1= "USD";
                divisa2= "JPY";
            } else if (busqueda.equals("5")) {
                divisa1= "USD";
                divisa2= "CAD";
            } else if (busqueda.equals("6")) {
                break;        
            } else {
                System.out.println("Opcion no valida");
                break;
            }
           
            Monedas divisa = new Monedas();
            divisa.setMoneda1(divisa1);
            divisa.setMoneda2(divisa2);
            Scanner dinero = new Scanner(System.in);
            
            System.out.println("Ingrese la cantidad de " + divisa.getMoneda1() + " que quieres convertir a " + divisa.getMoneda2());
            
            Double Amount = dinero.nextDouble();
            divisa.setCantidad(Amount);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
            String key = "1fc13da3e835cfcce43e7faa";
            
            String direccion = "https://v6.exchangerate-api.com/v6/"+ key + "/pair/" + divisa.getMoneda1() + "/" + divisa.getMoneda2()+ "/" + divisa.getCantidad()  ;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create(direccion))
                     .build();
         
            final HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
        
            String json = response.body();
            System.out.println("El resultado es: " + json);

    
            Monedas moneResul = gson.fromJson(json, Monedas.class);

            System.out.println(moneResul);
            
        }
    }
}