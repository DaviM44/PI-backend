package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.DisciplinaRequest;
import com.example.projetointegrador.dtos.DisciplinaResponse;
import com.example.projetointegrador.entities.Disciplina;
import com.example.projetointegrador.mappers.DisciplinaMapper;
import com.example.projetointegrador.repositories.DisciplinaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DisciplinaService {
    
    @Autowired
    private DisciplinaRepository repository;

     public List<Disciplina> getDisciplina(){
        return this.repository.findAll();
     }
     
  public Disciplina getDisciplina(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Disciplina not found"));
   }

   public void deleteDisciplinaById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Disciplina not found");

      }
   }
    public DisciplinaResponse save(DisciplinaRequest disciplina) {
    var entity =  this.repository.save(DisciplinaMapper.toEntity(disciplina));
    return DisciplinaMapper.toDTO(entity);
   }

   public void update(long id, DisciplinaRequest disciplina) {
      try {
         var updateDisciplina= this.repository.getReferenceById(id);
         updateDisciplina.setNome(disciplina.nome());
         updateDisciplina.setCargahoraria(disciplina.cargahoraria());

         this.repository.save(updateDisciplina);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Disciplina not found");
      }

   }

}