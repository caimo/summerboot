package com.summerboot.restservice.dto;

import java.util.Map;

public class TemplateIdMapDto {
    private Map<String, String> templateMap;

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    private boolean append = true;

    public Map<String, String> getTemplateMap() {
        return templateMap;
    }

    public void setTemplateMap(Map<String, String> templateMap) {
        this.templateMap = templateMap;
    }
}
