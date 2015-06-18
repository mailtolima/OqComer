package br.ufc.virtual.smd.oqcomer.vo;

import java.io.Serializable;

/**
 * Created by leoomoreira on 14/06/2015.
 */
public class Estabelecimento implements Serializable {

    private double latitude;
    private double longitude;
    private String nome;
    private int id;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
