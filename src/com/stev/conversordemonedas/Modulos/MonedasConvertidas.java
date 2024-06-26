package com.stev.conversordemonedas.Modulos;

import com.google.gson.annotations.SerializedName;

public class MonedasConvertidas {
    @SerializedName("conversion_result")
    private Double conversion;

    public MonedasConvertidas() {
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    @Override
    public String toString() {
        return "MonedasConvertidas [conversion= " + conversion + "]";
    } 

}
