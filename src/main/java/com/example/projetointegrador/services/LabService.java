package com.example.projetointegrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetointegrador.dtos.LabRequest;
import com.example.projetointegrador.dtos.LabResponse;
import com.example.projetointegrador.entities.Lab;
import com.example.projetointegrador.mappers.LabMapper;
import com.example.projetointegrador.repositories.LabRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LabService {
 
    @Autowired
    private LabRepository repository;

     public List<Lab> getLab(){
        return this.repository.findAll();
     }
     
  public Lab getLab(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Lab not found"));
   }

   public void deleteLabById(long id) {
      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }
      else {
         throw new EntityNotFoundException("Sala not found");

      }
   }
    public LabResponse save(LabRequest lab) {
    var entity =  this.repository.save(LabMapper.toEntity(lab));
    return LabMapper.toDTO(entity);
   }

   public void update(long id, LabRequest lab) {
      try {
         var updateLab= this.repository.getReferenceById(id);
         updateLab.setNomedolab(lab.nomedolab());
         updateLab.setDescricao(lab.descricao());
         updateLab.setCapacidade(lab.capacidade());
         updateLab.setNdm(lab.ndm());

         this.repository.save(updateLab);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("lab not found");
      }

   }

}

