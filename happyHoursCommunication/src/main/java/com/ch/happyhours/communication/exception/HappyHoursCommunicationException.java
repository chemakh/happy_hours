package com.ch.happyhours.communication.exception;


public class HappyHoursCommunicationException extends Exception
{

    private String message;
    private Throwable cause;


    public HappyHoursCommunicationException()
    {
    }


    public HappyHoursCommunicationException(Throwable cause)
    {
        super(cause);
        this.cause = cause;
    }

    public HappyHoursCommunicationException(String message)
    {
        super(message);
        this.message = message;
    }

    public HappyHoursCommunicationException(String message, Throwable cause)
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
