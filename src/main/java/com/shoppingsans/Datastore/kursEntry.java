package com.shoppingsans.Datastore;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
public class kursEntry implements Serializable{
    private String key;
    private int value;
}
