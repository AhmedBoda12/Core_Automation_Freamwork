package com.boda.utils.dateReader;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.boda.utils.logs.LogsManager;
import com.jayway.jsonpath.JsonPath;

public class JsonReader {
    private final String TEST_DATA_PATH = PropertyReader.getProperty("testDataPath");

    String jsonReader;
    String jsonFileName;

    public JsonReader(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject date = (JSONObject) new JSONParser().parse(new FileReader(TEST_DATA_PATH + jsonFileName));
            jsonReader = date.toString();
        } catch (Exception e) {
            LogsManager.error("Error reading JSON file: " + jsonFileName, e.getMessage());
            jsonReader = "{}";
        }
    }

    public String getJsonReader(String jsonPath) {
        try{
            return JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            LogsManager.error("Error parsing JSON path: " + jsonPath, e.getMessage());
            return "";
        }
    }

}
