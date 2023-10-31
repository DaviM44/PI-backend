package com.example.projetointegrador.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.projetointegrador.dtos.AdminRequest;
import com.example.projetointegrador.dtos.AdminResponse;
import com.example.projetointegrador.mappers.AdminMapper;
import com.example.projetointegrador.services.AdminService;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAdmin() {
        var Admin = this.service.getAdmin();
        return ResponseEntity.ok(AdminMapper.toDTOList(Admin));
    }

    @PostMapping
    public ResponseEntity<AdminResponse> save(@Validated  @RequestBody AdminRequest Professor){
        var savedProfessor = this.service.save(Professor);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedProfessor.id())

                .toUri();
        return ResponseEntity.created(location).body(savedProfessor);
    }
}