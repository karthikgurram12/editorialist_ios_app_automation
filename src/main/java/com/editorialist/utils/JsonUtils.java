package com.editorialist.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode readJsonFromFile(String filepath) throws IOException {
        return objectMapper.readTree(new File(filepath));
    }

    public static JsonNode getHighLevelKey(String filepath, String key) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(new File(filepath));
        return jsonNode.get(key);
    }
}
