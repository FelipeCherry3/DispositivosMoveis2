package com.facens.atividadedm2.model;

import java.io.Serializable;

public class Local implements Serializable {
    private String nome;
    private int imageResourceId;
    private String descricao;
    private String mapUrl;
    private String phone;
    private String site;

    public Local(String nome) {
        this.nome = nome;
    }

    public Local(String nome, int imageResourceId, String descricao, String mapUrl, String phone, String site) {
        this.nome = nome;
        this.imageResourceId = imageResourceId;
        this.descricao = descricao;
        this.mapUrl = mapUrl;
        this.phone = phone;
        this.site = site;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
