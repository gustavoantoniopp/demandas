package com.example.demandas.demandas.demands.model;

import com.example.demandas.demandas.demands.dto.DemandForm;
import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String objeto;
    private String area;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private ServiceType service;

    public Demand(){
    }

    public Demand(Long id, String objeto, String area, ServiceType service) {
        this.id = id;
        this.objeto = objeto;
        this.area = area;
        this.service = service;
    }

    public static Demand from(DemandForm demandForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(demandForm, Demand.class);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demand demand = (Demand) o;
        return Objects.equals(id, demand.id) && Objects.equals(objeto, demand.objeto) && Objects.equals(area, demand.area) && Objects.equals(service, demand.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objeto, area, service);
    }
}
