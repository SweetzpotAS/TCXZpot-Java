package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.Version;

public class VersionBuilder {

    public static VersionBuilder version() {
        return new VersionBuilder();
    }

    private Integer versionMajor;
    private Integer versionMinor;
    private Integer buildMajor;
    private Integer buildMinor;

    private VersionBuilder() {
    }

    public VersionBuilder major(int versionMajor) {
        this.versionMajor = versionMajor;
        return this;
    }

    public VersionBuilder minor(int versionMinor) {
        this.versionMinor = versionMinor;
        return this;
    }

    public VersionBuilder buildMajor(int buildMajor) {
        this.buildMajor = buildMajor;
        return this;
    }

    public VersionBuilder buildMinor(int buildMinor) {
        this.buildMinor = buildMinor;
        return this;
    }

    public Version build() {
        if(buildMajor == null || buildMinor == null) {
            return new Version(versionMajor, versionMinor);
        } else {
            return new Version(versionMajor, versionMinor, buildMajor, buildMinor);
        }
    }
}
