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
import com.example.projetointegrador.dtos.SalaRequest;
import com.example.projetointegrador.dtos.SalaResponse;
import com.example.projetointegrador.mappers.SalaMapper;
import com.example.projetointegrador.services.SalaService;

@RestController
@RequestMapping("sala")
@CrossOrigin
public class SalaController {
    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<SalaResponse>> getSala() {
        var Sala = this.service.getSala();
        return ResponseEntity.ok(SalaMapper.toDTOList(Sala));
    }

    @GetMapping("{id}")
    public ResponseEntity<SalaResponse> getSala(@PathVariable long id) {
        var Sala = this.service.getSala(id);
       return ResponseEntity.ok(SalaMapper.toDTO(Sala));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable long id) {
     this.service.deleteSalaById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<SalaResponse> save(@Validated  @RequestBody SalaRequest Sala){
        var savedSala = this.service.save(Sala);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedSala.id())

                .toUri();
        return ResponseEntity.created(location).body(savedSala);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody SalaRequest Sala){
    this.service.update(id,Sala);
        return ResponseEntity.ok().build();

    }
}

