package com.sweetzpot.tcxzpot;

public class Application extends AbstractSource{

    private final Build build;
    private final String languageID;
    private final String partNumber;

    public Application(String name, Build build, String languageID, String partNumber) {
        super(name);
        this.build = build;
        this.languageID = languageID;
        this.partNumber = partNumber;
    }
}
