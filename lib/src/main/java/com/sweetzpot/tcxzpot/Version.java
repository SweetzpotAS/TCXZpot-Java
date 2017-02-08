package com.sweetzpot.tcxzpot;

public class Version {

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
}
