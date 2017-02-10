package com.sweetzpot.tcxzpot.serializers;

import com.sweetzpot.tcxzpot.Serializer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSerializer implements Serializer {

    private BufferedWriter writer;

    public FileSerializer(File file) throws IOException {
        writer = new BufferedWriter(new FileWriter(file));
    }

    @Override
    public void print(String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException ignore) {}
    }

    public void save() throws IOException {
        writer.flush();
        writer.close();
    }
}
