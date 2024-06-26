package com.conversor.conversordemonedas.Modulos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

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