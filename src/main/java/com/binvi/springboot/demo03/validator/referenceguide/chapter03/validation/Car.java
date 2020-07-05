package com.binvi.springboot.demo03.validator.referenceguide.chapter03.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/20 21:36
 */
public class Car {

    public Car(@NotNull String manufacturer) {

    }

    @ValidRacingCar
    public Car(String manufacturer, String team) {

    }

    public void drive(@Max(75) int speedInMph) {

    }

    @Size(min = 1)
    public List<Passenger> getPassengers() {
        return Collections.emptyList();
    }

}

