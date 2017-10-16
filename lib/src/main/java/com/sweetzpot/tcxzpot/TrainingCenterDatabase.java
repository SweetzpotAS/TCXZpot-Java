package com.sweetzpot.tcxzpot;

public class TrainingCenterDatabase implements TCXSerializable {

    private final Activities activities;
    private final AbstractSource author;
    private final TCXExtension[] extensions;

    public TrainingCenterDatabase(Activities activities, AbstractSource author, TCXExtension... extensions) {
        this.activities = activities;
        this.author = author;
        this.extensions = extensions;
    }

    @Override
    public void serialize(Serializer serializer) {
        serializer.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        serializer.print("<TrainingCenterDatabase\n" +
                "  xsi:schemaLocation=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd\"\n" +
                "  xmlns=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2\"\n" +
                "  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        if(activities != null) activities.serialize(serializer);
        if(author != null) {
            serializer.print("<Author xsi:type=\"" + author.tcxType() + "\">");
            author.serialize(serializer);
            serializer.print("</Author>");
        }
        if(extensions != null && extensions.length > 0) {
            serializer.print("<Extensions>");
            for(TCXExtension extension : extensions) {
                extension.serialize(serializer);
            }
            serializer.print("</Extensions>");
        }
        serializer.print("</TrainingCenterDatabase>");
    }
}
