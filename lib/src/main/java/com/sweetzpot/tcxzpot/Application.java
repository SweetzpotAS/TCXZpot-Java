package com.sweetzpot.tcxzpot;

public class Application extends AbstractSource {

    private final Build build;
    private final String languageID;
    private final String partNumber;

    public Application(String name, Build build, String languageID, String partNumber) {
        super(name);
        this.build = build;
        this.languageID = languageID;
        this.partNumber = partNumber;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Application>");
        serializer.print("<Name>" + name + "</Name>");
        build.serialize(serializer);
        serializer.print("<LangID>" + languageID + "</LangID>");
        serializer.print("<PartNumber>" + partNumber + "</PartNumber>");
        serializer.print("</Application>");
    }
}
