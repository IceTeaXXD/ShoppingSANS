package com.shoppingsans.Bill;

// import java.io.Serializable;
// import java.util.ArrayList;

// import javax.xml.bind.annotation.XmlAccessorType;
// import javax.xml.bind.annotation.XmlAccessType;
// import javax.xml.bind.annotation.XmlElement;

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
public class Pembelian implements Serializable{
    private List<Entry> entry;
}