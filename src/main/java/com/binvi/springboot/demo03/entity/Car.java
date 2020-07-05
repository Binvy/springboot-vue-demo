package com.binvi.springboot.demo03.entity;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description: hibernate-validator 实体类
 * @date 2019/6/17 22:08
 */
@Data
public class Car {

    @NotNull(message = "must not be null")
    private String manufacturer;

    @Size(min = 2, max = 14, message = "The license plate '${validatedValue}' must between {min} and {max} characters long")
    private String licensePlate;

    @Min(value = 2, message = "There must be at least {value} seat${value > 1 ? 's' : ''}")
    private int seatCount;

    @DecimalMax(value = "350", message = "The top speed ${formatter.format('%1$.2f', validatedValue)} is higher than {value}")
    private double topSpeed;

    @DecimalMax(value = "100000", message = "Price must not be higher than ${value}")
    private BigDecimal price;

    @Valid
    List<BMW> bmwList;

    @Valid
    List<Audi> audiList;

}
