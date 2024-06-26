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
    private String periodo ;
    @Column(length = 100, nullable = false, name = "curso")
    private String curso;
    @Column(length = 100, nullable = false, name = "disciplina")
    private String disciplina;
    @Column(length = 100, nullable = false, name = "professor")
    private String professor;
    @Column(length = 100, nullable = false, name = "horario")
    private String horario;
    @Column(length = 100, nullable = false, name = "sala")
    private String sala;
    @Column(length = 100, nullable = false, name = "lab")
    private String lab;

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
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String string) {
        this.professor = string;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
    public String getLab() {
        return lab;
    }
    public void setLab(String lab) {
        this.lab = lab;
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
