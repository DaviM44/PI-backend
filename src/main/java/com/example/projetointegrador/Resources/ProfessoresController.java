package com.example.projetointegrador.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projetointegrador.dtos.ProfessorRequest;
import com.example.projetointegrador.dtos.ProfessorResponse;
import com.example.projetointegrador.mappers.ProfessorMapper;
import com.example.projetointegrador.services.ProfessorService;

@RestController
@RequestMapping("professor")
@CrossOrigin
public class ProfessoresController {
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> getProfessor() {
        var Professor = this.service.getProfessor();
        return ResponseEntity.ok(ProfessorMapper.toDTOList(Professor));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfessorResponse> getProfessor(@PathVariable long id) {
        var Professor = this.service.getProfessor(id);
       return ResponseEntity.ok(ProfessorMapper.toDTO(Professor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable long id) {
     this.service.deleteProfessorById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> save(@Validated  @RequestBody ProfessorRequest Professor){
        var savedProfessor = this.service.save(Professor);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedProfessor.id())

                .toUri();
        return ResponseEntity.created(location).body(savedProfessor);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody ProfessorRequest Professor){
    this.service.update(id,Professor);
        return ResponseEntity.ok().build();

    }
}

