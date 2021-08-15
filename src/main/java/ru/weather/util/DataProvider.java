package ru.weather.util;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataProvider {

    public static <T> T getObjectFromJson(String jsonName, Class c) {
        Object obj = null;
        String absPath = new File("").getAbsolutePath() + "/src/test/resources/mock/" + jsonName + ".json";
        File file = new File(absPath);
        try {
            String json = FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());
            Gson gson = new Gson();
            obj = gson.fromJson(json, c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T) obj;

    }
}
