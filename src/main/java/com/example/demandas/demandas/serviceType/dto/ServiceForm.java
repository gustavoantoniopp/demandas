package com.example.demandas.demandas.serviceType.dto;

import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ServiceForm {

    @NotNull
    @NotBlank
    private String type;

    public static ServiceForm from(ServiceType serviceType){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(serviceType, ServiceForm.class);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}