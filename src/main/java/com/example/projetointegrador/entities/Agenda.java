package com.example.projetointegrador.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_Agenda")
public class Agenda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, name = "dia")
    private String dia;
    @Column(length = 100, nullable = false, name = "ano")
    private String ano;
    @Column(length = 100, nullable = false, name = "semestre")
    private String semestre;
    @Column(length = 100, nullable = false, name = "periodo")
    private Integer periodo ;
    @Column(length = 100, nullable = false, name = "curso")
    private Integer curso;
    @Column(length = 100, nullable = false, name = "disciplina")
    private Integer disciplina;
    @Column(length = 100, nullable = false, name = "professor")
    private Integer professor;
    @Column(length = 100, nullable = false, name = "horario")
    private Integer horario;
    @Column(length = 100, nullable = false, name = "sala")
    private Integer sala;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public Integer getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
    public Integer getCurso() {
        return curso;
    }
    public void setCurso(Integer curso) {
        this.curso = curso;
    }
    public Integer getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Integer disciplina) {
        this.disciplina = disciplina;
    }
    public Integer getProfessor() {
        return professor;
    }
    public void setProfessor(Integer professor) {
        this.professor = professor;
    }
    public Integer getHorario() {
        return horario;
    }
    public void setHorario(Integer horario) {
        this.horario = horario;
    }
    public Integer getSala() {
        return sala;
    }
    public void setSala(Integer sala) {
        this.sala = sala;
    }
    
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Agenda other = (Agenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
