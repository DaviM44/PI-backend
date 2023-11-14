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

import com.example.projetointegrador.dtos.AgendaRequest;
import com.example.projetointegrador.dtos.AgendaResponse;
import com.example.projetointegrador.mappers.AgendaMapper;
import com.example.projetointegrador.services.AgendaService;

@RestController
@RequestMapping("agenda")
@CrossOrigin
public class AgendaController {
    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> getAgenda() {
        var Agenda= this.service.getAgenda();
        return ResponseEntity.ok(AgendaMapper.toDTOList(Agenda));
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaResponse> getAgenda(@PathVariable long id) {
        var Agenda = this.service.getAgenda(id);
       return ResponseEntity.ok(AgendaMapper.toDTO(Agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable long id) {
     this.service.deleteAgendaById(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AgendaResponse> save(@Validated  @RequestBody AgendaRequest Agenda){
        var savedAgenda = this.service.save(Agenda);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedAgenda.id())

                .toUri();
        return ResponseEntity.created(location).body(savedAgenda);
    }

    @PutMapping("{id}")
   public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody AgendaRequest Agenda){
    this.service.update(id,Agenda);
        return ResponseEntity.ok().build();

    }
}

