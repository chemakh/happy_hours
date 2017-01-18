package com.ch.happyhours.auth.exception;


public class HappyHoursException extends Exception
{

    private String message;

    private Throwable cause;


    public HappyHoursException()
    {
    }


    public HappyHoursException(Throwable cause)
    {
        super(cause);
        this.cause = cause;
    }

    public HappyHoursException(String message)
    {
        super(message);
        this.message = message;
    }

    public HappyHoursException(String message, Throwable cause)
    {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public Throwable getCause()
    {
        return cause;
    }

    public void setCause(Throwable cause)
    {
        this.cause = cause;
    }
}
