package com.example.demandas.demandas.demands.dto;

import com.example.demandas.demandas.demands.model.Demand;
import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DemandForm{

    @NotNull
    @NotBlank
    private String objeto;
    private String area;
    private ServiceType service;

    public static DemandForm from(Demand demand){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(demand, DemandForm.class);
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
