package com.sweetzpot.tcxzpot;

public class Build {

    private final Version version;
    private final BuildType type;
    private final String time;

    public Build(Version version, BuildType type, String time) {
        this.version = version;
        this.type = type;
        this.time = time;
    }
}
