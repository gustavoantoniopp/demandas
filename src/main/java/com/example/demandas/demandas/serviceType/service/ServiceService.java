package com.example.demandas.demandas.serviceType.service;

import com.example.demandas.demandas.serviceType.dto.ServiceDto;
import com.example.demandas.demandas.serviceType.dto.ServiceForm;
import com.example.demandas.demandas.serviceType.model.ServiceType;
import com.example.demandas.demandas.serviceType.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {
    private static final String ID_NOT_FOUND = "ID não encontrado";
    private final Logger logger = LoggerFactory.getLogger(ServiceService.class);

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceDto> findAll(){
        List<ServiceType> result = repository.findAll();
        return result.stream().map(ServiceDto::from).collect(Collectors.toList());
    }
    public ServiceDto findById(Long id){
        return ServiceDto.from(repository.findById(id).orElseThrow(() -> {
            logger.error("Not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND );
        }));
    }

    public ServiceDto save(ServiceForm serviceForm){
        if(repository.findByTypeContaining(serviceForm.getType()).isPresent()){
            logger.error("Service Exists {}", serviceForm.getType());
        }

        ServiceType serviceType = ServiceType.from(serviceForm);

        return ServiceDto.from(repository.save(serviceType));
    }

    public ServiceDto update(ServiceForm serviceForm, Long id){

        var modelMapper = new ModelMapper();
        var serviceType = repository.findById(id).orElseThrow(() -> {
            logger.error("Not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });

        modelMapper.map(serviceForm, serviceType);

        return ServiceDto.from(repository.save(serviceType));
    }
    public void delete(Long id) {
        ServiceType serviceType = repository.findById(id).orElseThrow(() -> {
            logger.error("Not found ");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });

        repository.delete(serviceType);
    }
}

