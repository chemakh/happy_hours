package com.ch.happyhours.communication.web.error;

import java.io.Serializable;


public class ErrorDTO implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String message = null;
    private String description = null;


    public ErrorDTO(String message)
    {
        this(message, null);
    }

    public ErrorDTO(String message, String description)
    {
        this.message = message;
        this.description = description;
    }


    public String getMessage()
    {
        return message;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString()
    {
        return "ErrorDTO{" +
                "message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
