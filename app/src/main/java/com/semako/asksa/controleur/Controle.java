package com.semako.asksa.controleur;

public final class Controle {
    private static Controle instance = null;

    private Controle(){
        super();
    }

    public static final Controle getInstance(){
        if (Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }
}
