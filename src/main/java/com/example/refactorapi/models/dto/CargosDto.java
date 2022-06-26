package com.example.refactorapi.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CargosDto {

    @NotBlank
    private String nomeCargo;
    @NotNull
    private float valorMin;
    @NotNull
    private float valorMax;

    public CargosDto() {
    }

    public CargosDto(String nomeCargo, float valorMin, float valorMax) {
        this.nomeCargo = nomeCargo;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public float getValorMin() {
        return valorMin;
    }

    public void setValorMin(float valorMin) {
        this.valorMin = valorMin;
    }

    public float getValorMax() {
        return valorMax;
    }

    public void setValorMax(float valorMax) {
        this.valorMax = valorMax;
    }

    @Override
    public String toString() {
        return "CargosDto{" +
                "nomeCargo='" + nomeCargo + '\'' +
                ", valorMin=" + valorMin +
                ", valorMax=" + valorMax +
                '}';
    }
}