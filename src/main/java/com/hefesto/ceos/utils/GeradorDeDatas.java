package com.hefesto.ceos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class GeradorDeDatas {

    private static GeradorDeDatas instance;
    public static GeradorDeDatas getInstance(){
        if(isNull(instance))
            instance = new GeradorDeDatas();
        return instance;
    }

    public String dataFormatada(LocalDateTime data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public String dataFormatadaComHora(LocalDateTime data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        return data.format(formatter);
    }
}
