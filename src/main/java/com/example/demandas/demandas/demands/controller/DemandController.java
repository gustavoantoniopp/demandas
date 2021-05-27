package com.example.demandas.demandas.demands.controller;

import com.example.demandas.demandas.demands.dto.DemandDto;
import com.example.demandas.demandas.demands.dto.DemandForm;
import com.example.demandas.demandas.demands.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/DEMANDS")
public class DemandController {

    private final DemandService service;

    @Autowired
    public DemandController(DemandService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DemandDto>> listServices(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DemandDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<DemandDto> save(@RequestBody @Validated DemandForm demandForm){
        return ResponseEntity.ok(service.save(demandForm));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DemandDto> update(@PathVariable Long id, @RequestBody @Validated DemandForm demandForm){
        return ResponseEntity.ok(service.update(demandForm, id));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
