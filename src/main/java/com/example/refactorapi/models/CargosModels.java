package com.example.refactorapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Cargos_Refactor")
public class CargosModels implements Serializable {
    private static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idcargos;
    @Column(nullable = false)
    private String nomeCargo;
    @Column(nullable = false)
    private float valorMin;
    @Column(nullable = false)
    private  float valorMax;

    public CargosModels() {
    }

    public CargosModels(long idcargos, String nomeCargo, float valorMin, float valorMax) {
        this.idcargos = idcargos;
        this.nomeCargo = nomeCargo;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public CargosModels(String nomeCargo, float valorMin, float valorMax) {
        this.nomeCargo = nomeCargo;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }

    public long getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(long idcargos) {
        this.idcargos = idcargos;
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
        return "CargosModels{" +
                "idcargos=" + idcargos +
                ", nomeCargo='" + nomeCargo + '\'' +
                ", valorMin=" + valorMin +
                ", valorMax=" + valorMax +
                '}';
    }
}