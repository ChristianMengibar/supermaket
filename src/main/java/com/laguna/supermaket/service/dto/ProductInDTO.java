package com.laguna.supermaket.service.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class ProductInDTO {
    //Como buena práctica nos recomiendan hacer los constructores, getter y setter,
    // pero el IntelliJ nos sugiere que con la anotacion @Setter podemos eliminarlos
    // y mantiene la misma funcionalidad
    @Setter
    private Long id;
    private String name;
    private String description;
    private double price;
}
