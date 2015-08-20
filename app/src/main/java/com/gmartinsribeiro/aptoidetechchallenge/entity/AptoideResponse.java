package com.gmartinsribeiro.aptoidetechchallenge.entity;

/**
 * Created by Gonçalo Martins Ribeiro on 20-08-2015.
 */
public class AptoideResponse
{
    private String status;

    private Response responses;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Response getResponses ()
    {
        return responses;
    }

    public void setResponses (Response responses)
    {
        this.responses = responses;
    }
}
