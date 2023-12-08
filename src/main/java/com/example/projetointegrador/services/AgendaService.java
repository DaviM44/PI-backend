package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.AgendaRequest;
import com.example.projetointegrador.dtos.AgendaResponse;
import com.example.projetointegrador.entities.Agenda;
import com.example.projetointegrador.mappers.AgendaMapper;
import com.example.projetointegrador.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository repository;

     public List<Agenda> getAgenda(){
        return this.repository.findAll();
     }
     
  public Agenda getAgenda(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Agenda not found"));
   }

   public void deleteAgendaById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Agenda not found");

      }
   }
    public AgendaResponse save(AgendaRequest agenda) {
    var entity =  this.repository.save(AgendaMapper.toEntity(agenda));
    return AgendaMapper.toDTO(entity);
   }

   public void update(long id, AgendaRequest agenda) {
      try {
         var updateAgenda= this.repository.getReferenceById(id);
         updateAgenda.setDia(agenda.dia());
         updateAgenda.setAno(agenda.ano());
         updateAgenda.setSemestre(agenda.semestre());
         updateAgenda.setPeriodo(agenda.periodo());
         updateAgenda.setCurso(Integer.parseInt(agenda.curso()));
         updateAgenda.setDisciplina(Integer.parseInt(agenda.disciplina()));
         updateAgenda.setHorario(Integer.parseInt(agenda.horario()));
         updateAgenda.setSala(Integer.parseInt(agenda.sala()));
         updateAgenda.setProfessor(agenda.professor());

         this.repository.save(updateAgenda);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Agenda not found");
      }

   }

}

