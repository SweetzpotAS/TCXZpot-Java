package com.sweetzpot.tcxzpot.builders;

import com.sweetzpot.tcxzpot.Application;
import com.sweetzpot.tcxzpot.Build;

import static com.sweetzpot.tcxzpot.builders.StringUtil.isNullOrEmpty;

public class ApplicationBuilder extends AbstractSourceBuilder {

    public static ApplicationBuilder application(String name) {
        return new ApplicationBuilder(name);
    }

    private String name;
    private Build build;
    private String languageID;
    private String partNumber;

    private ApplicationBuilder(String name) {
        this.name = name;
    }

    public ApplicationBuilder withBuild(Build build) {
        this.build = build;
        return this;
    }

    public ApplicationBuilder withBuild(BuildBuilder buildBuilder) {
        this.build = buildBuilder.build();
        return this;
    }

    public ApplicationBuilder withLanguageID(String languageID) {
        this.languageID = languageID;
        return this;
    }

    public ApplicationBuilder withPartNumber(String partNumber) {
        this.partNumber = partNumber;
        return this;
    }

    public Application build() {
        validateArguments();
        return new Application(name, build, languageID, partNumber);
    }

    private void validateArguments() {
        if(isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Application must have a non-empty Name");
        }
        if(build == null) {
            throw new IllegalArgumentException("Application must have a Build");
        }
        if(isNullOrEmpty(languageID)) {
            throw new IllegalArgumentException("Application must have a LangID");
        }
        if(isNullOrEmpty(partNumber)) {
            throw new IllegalArgumentException("Application must have a PartNumber");
        }
    }
}
