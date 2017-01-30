package com.ch.happyhours.service.domain;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Chemakh on 23/01/2017.
 */
public enum ManagerFct {

    Directeur,
    Manager,
    Proprietaire;

    public static ManagerFct fromString(final String fonction) {

        return fonction != null ?
                Arrays.stream(values()).filter(val -> Objects.equals(val.toString().toUpperCase(), fonction.toUpperCase().trim())).findFirst().orElse(null)
                : Manager;

    }
}
