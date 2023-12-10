package com.bulutmd.BasketService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Basket {
@Id
    @GeneratedValue
    private int id;


}
