package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.SalaRequest;
import com.example.projetointegrador.dtos.SalaResponse;
import com.example.projetointegrador.entities.Sala;
import com.example.projetointegrador.mappers.SalaMapper;
import com.example.projetointegrador.repositories.SalaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SalaService {
 
    @Autowired
    private SalaRepository repository;

     public List<Sala> getSala(){
        return this.repository.findAll();
     }
     
  public Sala getSala(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sala not found"));
   }

   public void deleteSalaById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Sala not found");

      }
   }
    public SalaResponse save(SalaRequest sala) {
    var entity =  this.repository.save(SalaMapper.toEntity(sala));
    return SalaMapper.toDTO(entity);
   }

   public void update(long id, SalaRequest sala) {
      try {
         var updateSala= this.repository.getReferenceById(id);
         updateSala.setNomedasala(sala.nomedasala());
         updateSala.setDescricao(sala.descricao());
         updateSala.setCapacidade(sala.capacidade());

         this.repository.save(updateSala);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Sala not found");
      }

   }

}

