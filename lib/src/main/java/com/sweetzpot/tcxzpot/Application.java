package com.sweetzpot.tcxzpot;

public class Application {

    private final String name;
    private final Build build;
    private final String languageID;
    private final String partNumber;

    public Application(String name, Build build, String languageID, String partNumber) {
        this.name = name;
        this.build = build;
        this.languageID = languageID;
        this.partNumber = partNumber;
    }
}
