package com.ch.happyhours.service.web.error;

import java.io.Serializable;
import java.util.Arrays;

/**
 * DTO for sending a parameterized error message.
 */
public class ParameterizedErrorDTO implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final String message;
    private final String[] params;

    public ParameterizedErrorDTO(String message, String... params)
    {
        this.message = message;
        this.params = params;
    }

    public String getMessage()
    {
        return message;
    }

    public String[] getParams()
    {
        return params;
    }

    @Override
    public String toString()
    {
        return "ParameterizedErrorDTO{" +
                "message='" + message + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
