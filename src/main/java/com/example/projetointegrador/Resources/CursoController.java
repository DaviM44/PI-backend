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

import com.example.projetointegrador.dtos.CursoRequest;
import com.example.projetointegrador.dtos.CursoResponse;
import com.example.projetointegrador.mappers.CursoMapper;
import com.example.projetointegrador.services.CursoService;


@RestController
@RequestMapping("curso")
@CrossOrigin
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> getCurso() {
        var Curso = this.service.getCurso();
        return ResponseEntity.ok(CursoMapper.toDTOList(Curso));
    }

    @GetMapping("{id}")
    public ResponseEntity<CursoResponse> getSala(@PathVariable long id) {
        var Curso = this.service.getCurso(id);
       return ResponseEntity.ok(CursoMapper.toDTO(Curso));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable long id) {
     this.service.deleteCursoById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CursoResponse> save(@Validated  @RequestBody CursoRequest Curso){
        var savedCurso = this.service.save(Curso);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedCurso.id())

                .toUri();
        return ResponseEntity.created(location).body(savedCurso);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody CursoRequest Curso){
    this.service.update(id,Curso);
        return ResponseEntity.ok().build();

    }
}

