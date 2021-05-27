package com.example.demandas.demandas.serviceType.dto;

import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.io.Serializable;

public class ServiceDto implements Serializable {

    private Long id;
    private String type;

    public static ServiceDto from(ServiceType serviceType){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(serviceType, ServiceDto.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
