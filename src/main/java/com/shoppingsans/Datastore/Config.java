package com.shoppingsans.Datastore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
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
    private HashMap<String, Integer> mapKurs;

    @XmlElement
    private Kurs kurs;
    
    @XmlElement
    private String currentKurs;

    public void createMap() {
        this.mapKurs = new HashMap<>();
        for (kursEntry entry : kurs.getEntry()) {
            this.mapKurs.put(entry.getKey(), entry.getValue());
        }
    }

    public void createKurs() {
        this.kurs = new Kurs();
        ArrayList<kursEntry> entries = new ArrayList<>();
        for (String key : mapKurs.keySet()) {
            entries.add(new kursEntry(key, mapKurs.get(key)));
        }
        this.kurs.setEntry(entries);
    }


}
