package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.CursoRequest;
import com.example.projetointegrador.dtos.CursoResponse;
import com.example.projetointegrador.entities.Curso;
import com.example.projetointegrador.mappers.CursoMapper;
import com.example.projetointegrador.repositories.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

     public List<Curso> getCurso(){
        return this.repository.findAll();
     }
     
  public Curso getCurso(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Curso not found"));
   }

   public void deleteCursoById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Curso not found");

      }
   }
    public CursoResponse save(CursoRequest curso) {
    var entity =  this.repository.save(CursoMapper.toEntity(curso));
    return CursoMapper.toDTO(entity);
   }

   public void update(long id, CursoRequest curso) {
      try {
         var updateCurso= this.repository.getReferenceById(id);
         updateCurso.setNome(curso.nome());
         updateCurso.setPeriodo(curso.periodo());
         updateCurso.setDuracao(curso.duracao());

         this.repository.save(updateCurso);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Curso not found");
      }

   }

}
