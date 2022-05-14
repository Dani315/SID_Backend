package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOCATION")
public class Location  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long serial;

    @Column
    private String address;

    @Column
    private String name;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public Long getSerial() {
        return serial;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
