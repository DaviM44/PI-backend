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
        agenda.setCurso(Integer.parseInt(request.curso()));
        agenda.setPeriodo(Integer.parseInt(request.periodo()));
        agenda.setDisciplina(Integer.parseInt(request.disciplina()));
        agenda.setHorario(Integer.parseInt(request.horario()));
        agenda.setSala(Integer.parseInt(request.sala()));
        agenda.setProfessor(Integer.parseInt(request.professor()));
        return agenda;
    }

    public static AgendaResponse toDTO(Agenda agenda) {
        return new AgendaResponse(
            agenda.getId(),
            agenda.getDia(),
            agenda.getSemestre(),
            agenda.getAno(),
            agenda.getCurso(),
            agenda.getDisciplina(),
            agenda.getHorario(),
            agenda.getSala(),
            agenda.getProfessor(),
            agenda.getCurso()
        );
    }

    public static List<AgendaResponse> toDTOList(List<Agenda> agenda) {
        return agenda.stream()
                .map(AgendaMapper::toDTO)
                .collect(Collectors.toList()); 
    }
}


