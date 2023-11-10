package com.example.projetointegrador.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_Disciplina")
public class Disciplina  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(length = 100, nullable = false, name = "nome")
    private String nome;
    @Column(length = 100, nullable = false, name = "cargahoraria")
    private String cargahoraria;
    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCargahoraria() {
        return cargahoraria;
    }
    public void setCargahoraria(String cargahoraria) {
        this.cargahoraria = cargahoraria;
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
        Disciplina other = (Disciplina) obj;
        if (Id != other.Id)
            return false;
        return true;
    }
    
}
