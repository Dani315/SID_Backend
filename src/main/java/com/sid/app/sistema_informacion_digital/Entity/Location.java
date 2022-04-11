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


}
