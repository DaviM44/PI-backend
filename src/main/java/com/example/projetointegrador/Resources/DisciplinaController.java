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
import com.example.projetointegrador.dtos.DisciplinaRequest;
import com.example.projetointegrador.dtos.DisciplinaResponse;
import com.example.projetointegrador.mappers.DisciplinaMapper;
import com.example.projetointegrador.services.DisciplinaService;

@RestController
@RequestMapping("disciplina")
@CrossOrigin
public class DisciplinaController {
    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> getCurso() {
        var Disciplina = this.service.getDisciplina();
        return ResponseEntity.ok(DisciplinaMapper.toDTOList(Disciplina));
    }

    @GetMapping("{id}")
    public ResponseEntity<DisciplinaResponse> getDisciplina(@PathVariable long id) {
        var Disciplina = this.service.getDisciplina(id);
       return ResponseEntity.ok(DisciplinaMapper.toDTO(Disciplina));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable long id) {
     this.service.deleteDisciplinaById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> save(@Validated  @RequestBody DisciplinaRequest Disciplina){
        var savedDisciplina = this.service.save(Disciplina);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedDisciplina.id())

                .toUri();
        return ResponseEntity.created(location).body(savedDisciplina);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody DisciplinaRequest Disciplina){
    this.service.update(id,Disciplina);
        return ResponseEntity.ok().build();

    }
}