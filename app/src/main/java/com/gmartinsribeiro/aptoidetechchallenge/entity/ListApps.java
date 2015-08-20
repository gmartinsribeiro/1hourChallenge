package com.gmartinsribeiro.aptoidetechchallenge.entity;

/**
 * Created by Gonçalo Martins Ribeiro on 20-08-2015.
 */
public class ListApps {

    private Datasets datasets;

    private Info info;

    public Datasets getDatasets ()
    {
        return datasets;
    }

    public void setDatasets (Datasets datasets)
    {
        this.datasets = datasets;
    }

    public Info getInfo ()
    {
        return info;
    }

    public void setInfo (Info info)
    {
        this.info = info;
    }
}
