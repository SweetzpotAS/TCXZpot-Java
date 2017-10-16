package com.sweetzpot.tcxzpot.util;

import com.sweetzpot.tcxzpot.Serializer;
import com.sweetzpot.tcxzpot.TCXExtension;

public class TCXExtensionSerialization {
    public static void serializeExtensions(TCXExtension[] extensions, Serializer serializer) {
        if(extensions != null && extensions.length > 0) {
            serializer.print("<Extensions>");
            for(TCXExtension extension : extensions) {
                extension.serialize(serializer);
            }
            serializer.print("</Extensions>");
        }
    }
}
