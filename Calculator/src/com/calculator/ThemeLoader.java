package com.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.calculator.Theme;
import com.calculator.ThemeList;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class ThemeLoader {

    private ThemeLoader() {
        throw new AssertionError("Constructor is not allowed");
    }

    public static Map<String, Theme> loadThemes() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            ThemeList themeList = mapper.readValue(new File("src/application.yaml"), ThemeList.class);
            return themeList.getThemesAsMap();
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }
}
