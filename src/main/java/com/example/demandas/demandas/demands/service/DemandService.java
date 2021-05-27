package com.example.demandas.demandas.demands.service;

import com.example.demandas.demandas.demands.dto.DemandDto;
import com.example.demandas.demandas.demands.dto.DemandForm;
import com.example.demandas.demandas.demands.model.Demand;
import com.example.demandas.demandas.demands.repository.DemandRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandService {
    private static final String ID_NOT_FOUND = "ID não encontrado";
    private final Logger logger = LoggerFactory.getLogger(DemandService.class);

    private final DemandRepository repository;

    public DemandService(DemandRepository repository){

        this.repository = repository;
    }

    public List<DemandDto> findAll(){
        List<Demand> result = repository.findAll();
        return result.stream().map(DemandDto::from).collect(Collectors.toList());
    }

    public DemandDto findById(Long id){
        return DemandDto.from(repository.findById(id).orElseThrow(() -> {
            logger.error("Not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND );
        }));
    }

    public DemandDto save(DemandForm demandForm){
        if(repository.findByObjetoContaining(demandForm.getObjeto()).isPresent()){
            logger.error("Demand Exists {}", demandForm.getObjeto());
        }

        Demand demand = Demand.from(demandForm);

        return DemandDto.from(repository.save(demand));
    }

    public DemandDto update(DemandForm demandForm, Long id){

        var modelMapper = new ModelMapper();
        var demand = repository.findById(id).orElseThrow(() -> {
            logger.error("Not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });

        modelMapper.map(demandForm, demand);

        return DemandDto.from(repository.save(demand));
    }
    public void delete(Long id) {
        Demand demand = repository.findById(id).orElseThrow(() -> {
            logger.error("Not found ");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });

        repository.delete(demand);
    }
}
