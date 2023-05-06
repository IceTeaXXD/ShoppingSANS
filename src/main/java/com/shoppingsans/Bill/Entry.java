package com.shoppingsans.Bill;

import javax.xml.bind.annotation.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {
    private String key;
    private int value;
}
