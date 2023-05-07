package com.shoppingsans.JualBarang;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author Azmi Hasna Zahrani - 13521006
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
public class Barang implements Serializable{
    @XmlElement(name = "idBarang")
    private int idBarang;
    @XmlElement(name = "namaBarang")
    @NonNull private String namaBarang;
    @XmlElement(name = "hargaBarang")
    private int hargaBarang;
    @XmlElement(name = "stokBarang")
    private int stokBarang;
    @XmlElement(name = "hargaBeli")
    private int hargaBeli;
    @XmlElement(name = "kategori")
    @NonNull private String kategori;
    @XmlElement(name = "gambar")
    @NonNull private String gambar;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Barang other = (Barang) obj;
        return idBarang == other.idBarang && namaBarang.equals(other.namaBarang);
    }
}