package com.example.demandas.demandas.serviceType.controller;

import com.example.demandas.demandas.serviceType.dto.ServiceDto;
import com.example.demandas.demandas.serviceType.dto.ServiceForm;
import com.example.demandas.demandas.serviceType.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/services")
public class ServiceController {

    private final ServiceService service;

    @Autowired
    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> listServices(){
        return  ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceDto> save(@RequestBody @Validated ServiceForm serviceForm) {
        return ResponseEntity.ok(service.save(serviceForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDto> update(@PathVariable Long id, @RequestBody @Validated ServiceForm serviceForm) {
        return ResponseEntity.ok(service.update(serviceForm, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
