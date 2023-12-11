package com.example.projetointegrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projetointegrador.dtos.AgendaRequest;
import com.example.projetointegrador.dtos.AgendaResponse;
import com.example.projetointegrador.entities.Agenda;

public class AgendaMapper {
    public static Agenda toEntity(AgendaRequest request) {
        Agenda agenda = new Agenda();
        agenda.setDia(request.dia());
        agenda.setAno(request.ano());
        agenda.setSemestre(request.semestre());
        agenda.setCurso(request.curso());
        agenda.setPeriodo(request.periodo());
        agenda.setDisciplina(request.disciplina());
        agenda.setHorario(request.horario());
        agenda.setSala(request.sala());
        agenda.setProfessor(request.professor());
        agenda.setLab(request.lab());
        return agenda;
    }

    public static AgendaResponse toDTO(Agenda agenda) {
        return new AgendaResponse(
            agenda.getId(),
            agenda.getDia(),
            agenda.getSemestre(),
            agenda.getAno(),
            agenda.getCurso(),
            agenda.getProfessor(),
            agenda.getSala(),
            agenda.getDisciplina(),
            agenda.getHorario(),
            agenda.getPeriodo(),
            agenda.getLab()
        );
    }

    public static List<AgendaResponse> toDTOList(List<Agenda> agenda) {
        return agenda.stream()
                .map(AgendaMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}


