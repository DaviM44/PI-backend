package com.example.projetointegrador.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_Lab")
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(length = 100, nullable = false, name = "nomedolab")
    private String nomedolab;
    @Column(length = 100, nullable = false, name = "capacidade")
    private String capacidade;
    @Column(length = 100, nullable = false, name = "descricao")
    private String descricao;
    @Column(length = 100, nullable = false, name = "ndm")
    private String ndm;

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getNomedolab() {
        return nomedolab;
    }
    public void setNomedolab(String nomedolab) {
        this.nomedolab = nomedolab;
    }
    public String getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNdm() {
        return ndm;
    }
    public void setNdm(String ndm) {
        this.ndm = ndm;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lab other = (Lab) obj;
        if (Id != other.Id)
            return false;
        return true;
    }
}


