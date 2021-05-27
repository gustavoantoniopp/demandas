package com.example.demandas.demandas.serviceType.model;

import com.example.demandas.demandas.demands.model.Demand;
import com.example.demandas.demandas.serviceType.dto.ServiceForm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SERVICES")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "service")
    private List<Demand> demands = new ArrayList<>();

    public ServiceType(){
    }

    public ServiceType(String type) {
        this.type = type;
    }

    public static ServiceType from(ServiceForm serviceForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(serviceForm, ServiceType.class);
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

    public List<Demand> getDemands() {
        return demands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceType)) return false;
        ServiceType service1 = (ServiceType) o;
        return getId().equals(service1.getId()) && Objects.equals(getType(), service1.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getType());
    }
}
