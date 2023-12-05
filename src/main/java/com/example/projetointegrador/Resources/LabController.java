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
import com.example.projetointegrador.dtos.LabRequest;
import com.example.projetointegrador.dtos.LabResponse;
import com.example.projetointegrador.mappers.LabMapper;
import com.example.projetointegrador.services.LabService;


@RestController
@RequestMapping("sala")
@CrossOrigin
public class LabController {
    @Autowired
    private LabService service;

    @GetMapping
    public ResponseEntity<List<LabResponse>> getLab() {
        var Lab = this.service.getLab();
        return ResponseEntity.ok(LabMapper.toDTOList(Lab));
    }

    @GetMapping("{id}")
    public ResponseEntity<LabResponse> getLab(@PathVariable long id) {
        var Lab = this.service.getLab(id);
       return ResponseEntity.ok(LabMapper.toDTO(Lab));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLab(@PathVariable long id) {
     this.service.deleteLabById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<LabResponse> save(@Validated  @RequestBody LabRequest Lab){
        var savedLab = this.service.save(Lab);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedLab.id())

                .toUri();
        return ResponseEntity.created(location).body(savedLab);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody LabRequest Lab){
    this.service.update(id,Lab);
        return ResponseEntity.ok().build();

    }
}

