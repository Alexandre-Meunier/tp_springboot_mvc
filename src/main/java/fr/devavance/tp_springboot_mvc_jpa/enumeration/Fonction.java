package fr.devavance.tp_springboot_mvc_jpa.enumeration;

import lombok.Getter;

@Getter
public enum Fonction {
    CHEF_PROJET("blue"),
    DEV_OPS("green"),
    DEV_WEB("purple"),
    DEV_AI("yellow"),
    SOFTWARE_ARCHITECT("orange");
    private final String codeCouleur;


    private Fonction(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }

}
