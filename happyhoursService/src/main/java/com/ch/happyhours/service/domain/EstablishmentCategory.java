package com.ch.happyhours.service.domain;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Chemakh on 23/01/2017.
 */
public enum EstablishmentCategory {

    SPA,
    Bar,
    Restaurant,
    Shopping,
    SalonDeThe;

    public static EstablishmentCategory fromString(final String est)
    {

        return est != null ?
                Arrays.stream(values()).filter(val -> Objects.equals(val.toString().toUpperCase(), est.toUpperCase().trim())).findFirst().orElse(null)
                : null;

    }



}
