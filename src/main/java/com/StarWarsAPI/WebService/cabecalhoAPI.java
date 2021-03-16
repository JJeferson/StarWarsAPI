package com.StarWarsAPI.WebService;

import java.util.List;

public class cabecalhoAPI {
    private int     count;
    private String  next ;
    private String  prevous;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevous() {
        return prevous;
    }

    @Override
    public String toString() {
        return "{}" ;
    }
}
