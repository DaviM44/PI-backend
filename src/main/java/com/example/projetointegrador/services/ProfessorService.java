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
    public ProfessorResponse save(ProfessorRequest student) {
    var entity =  this.repository.save(ProfessorMapper.toEntity(student));
    return ProfessorMapper.toDTO(entity);
   }

   public void update(long id, ProfessorRequest student) {
      try {
         var updateProfessor= this.repository.getReferenceById(id);
         updateProfessor.setNome(student.nome());
         updateProfessor.setEmail(student.email());
         updateProfessor.setTelefone(student.telefone());
         updateProfessor.setGenero(student.genero());

         this.repository.save(updateProfessor);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Student not found");
      }

   }

}

