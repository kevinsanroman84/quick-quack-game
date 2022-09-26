package com.quickquack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TrackImage {
    private String track;

    public String pullText(String filePath){
        String result = null;

        try {
            result= Files.readString(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}