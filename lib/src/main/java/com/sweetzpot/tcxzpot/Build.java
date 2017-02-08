package com.sweetzpot.tcxzpot;

public class Build implements TCXSerializable {

    private final Version version;
    private final BuildType type;
    private final String time;

    public Build(Version version, BuildType type, String time) {
        this.version = version;
        this.type = type;
        this.time = time;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<Build>");
        version.serialize(serializer);
        if(type != null) type.serialize(serializer);
        if(time != null) serializer.print("<Time>" + time + "</Time>");
        serializer.print("</Build>");
    }
}
