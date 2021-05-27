package com.example.demandas.demandas.demands.dto;

import com.example.demandas.demandas.demands.model.Demand;
import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.Serializable;

public class DemandDto implements Serializable {

    private Long id;
    private String objeto;
    private String area;

    private ServiceType service;

    public static DemandDto from(Demand demand){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(demand, DemandDto.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ServiceType getService() {
        return service;
    }

    public void setService(ServiceType service) {
        this.service = service;
    }
}
