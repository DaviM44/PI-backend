package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.ProfessorRequest;
import com.example.projetointegrador.dtos.ProfessorResponse;
import com.example.projetointegrador.entities.Professor;
import com.example.projetointegrador.mappers.ProfessorMapper;
import com.example.projetointegrador.repositories.ProfessorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repository;

     public List<Professor> getProfessor(){
        return this.repository.findAll();
     }
     
  public Professor getProfessor(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Professor not found"));
   }

   public void deleteProfessorById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Professor not found");

      }
   }
    public ProfessorResponse save(ProfessorRequest professor) {
    var entity =  this.repository.save(ProfessorMapper.toEntity(professor));
    return ProfessorMapper.toDTO(entity);
   }

   public void update(long id, ProfessorRequest professor) {
      try {
         var updateProfessor= this.repository.getReferenceById(id);
         updateProfessor.setNome(professor.nome());
         updateProfessor.setEmail(professor.email());
         updateProfessor.setTelefone(professor.telefone());
         updateProfessor.setGenero(professor.genero());

         this.repository.save(updateProfessor);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Professor not found");
      }

   }

}

