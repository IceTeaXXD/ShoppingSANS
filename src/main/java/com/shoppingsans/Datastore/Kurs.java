package com.shoppingsans.Datastore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @XmlAccessorType(XmlAccessType.FIELD)
// public class Pembelian {
//     private ArrayList<Pair<String, Integer>> entries;
// }


import java.util.List;
import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
public class Kurs implements Serializable{
    @XmlElement (name = "Entry")
    private List<kursEntry> entry;
}
