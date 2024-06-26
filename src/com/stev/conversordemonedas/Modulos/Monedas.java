package com.stev.conversordemonedas.Modulos;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Monedas{

    private String moneda1;
    private String moneda2;
    private Double cantidad;

    @SerializedName("conversion_result")
    private Double conversion;


    public Monedas(){

    }


    public String getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(String moneda1) {
        this.moneda1 = moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public void setMoneda2(String moneda2) {
        this.moneda2 = moneda2;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Este es el resultado de su conversion = " + conversion; 
    }


}