/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingsans.Datastore;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
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
@Getter
@Setter
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
}
