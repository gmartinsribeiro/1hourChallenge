package com.gmartinsribeiro.aptoidetechchallenge.entity;

import java.util.List;

/**
 * Created by Gonçalo Martins Ribeiro on 20-08-2015.
 */
public class Data {

    private String limit;

    private String total;

    private String hidden;

    private String next;

    private List<Item> list;

    private String offset;

    public String getLimit ()
    {
        return limit;
    }

    public void setLimit (String limit)
    {
        this.limit = limit;
    }

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getHidden ()
    {
        return hidden;
    }

    public void setHidden (String hidden)
    {
        this.hidden = hidden;
    }

    public String getNext ()
    {
        return next;
    }

    public void setNext (String next)
    {
        this.next = next;
    }

    public List<Item> getList ()
    {
        return list;
    }

    public void setList (List<Item> list)
    {
        this.list = list;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }
}
