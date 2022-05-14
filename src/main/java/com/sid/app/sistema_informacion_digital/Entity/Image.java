package com.sid.app.sistema_informacion_digital.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "IMAGE")
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;

    @Column
    private String productId;

    @Column
    private String url;

    public Long getCode() {
        return code;
    }

    public String getProductId() {
        return productId;
    }

    public String getUrl() {
        return url;
    }
}
