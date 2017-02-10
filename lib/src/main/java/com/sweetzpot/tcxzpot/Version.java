package com.sweetzpot.tcxzpot;

public class Version implements TCXSerializable {

    private final int versionMajor;
    private final int versionMinor;
    private final int buildMajor;
    private final int buildMinor;

    public Version(int versionMajor, int versionMinor) {
        this(versionMajor, versionMinor, 0, 0);
    }

    public Version(int versionMajor, int versionMinor, int buildMajor, int buildMinor) {
        this.versionMajor = versionMajor;
        this.versionMinor = versionMinor;
        this.buildMajor = buildMajor;
        this.buildMinor = buildMinor;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Version>");
        serializer.print("<VersionMajor>" + versionMajor + "</VersionMajor>");
        serializer.print("<VersionMinor>" + versionMinor + "</VersionMinor>");
        serializer.print("<BuildMajor>" + buildMajor + "</BuildMajor>");
        serializer.print("<BuildMinor>" + buildMinor + "</BuildMinor>");
        serializer.print("</Version>");
    }
}
