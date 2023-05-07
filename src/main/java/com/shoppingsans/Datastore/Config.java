/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Matthew
 */
@Data
@XmlRootElement(name = "Config")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)

public class Config {
    @XmlElement
    private String appName;
    @XmlElement
    private String saveas;
    @XmlElement
    private String path;
    @XmlElement
    private PluginPath plugins;
    
    @XmlTransient
    @JsonIgnore
    private HashMap<String, Integer> mapKurs;

    private Kurs kurs;

    public void createMap() {
        this.mapKurs = new HashMap<>();
        for (kursEntry entry : kurs.getEntry()) {
            this.mapKurs.put(entry.getKey(), entry.getValue());
        }
    }
}
