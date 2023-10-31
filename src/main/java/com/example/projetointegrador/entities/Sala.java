package com.example.projetointegrador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_Sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(length = 100, nullable = false, name = "nomedasala")
    private String nomedasala;
    @Column(length = 100, nullable = false, name = "tipo")
    private String tipo;
    @Column(length = 100, nullable = false, name = "capacidade")
    private String capacidade;
    @Column(length = 100, nullable = false, name = "ndm")
    private String ndm;
    @Column(length = 100, nullable = false, name = "descricao")
    private String descricao;
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getNomedasala() {
        return nomedasala;
    }
    public void setNomedasala(String nomedasala) {
        this.nomedasala = nomedasala;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
    public String getNdm() {
        return ndm;
    }
    public void setNdm(String ndm) {
        this.ndm = ndm;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        Sala other = (Sala) obj;
        if (Id != other.Id)
            return false;
        return true;
    }
    
}
