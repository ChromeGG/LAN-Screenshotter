package com.lanssmaker.logger.log;

public class Log {
    private String time;
    private String logContent;
    private LOG_CATEGORIES category;

    public Log(String time, String logContent, LOG_CATEGORIES category) {
        this.time = time;
        this.logContent = logContent;
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public LOG_CATEGORIES getCategory() {
        return category;
    }

    public void setCategory(LOG_CATEGORIES category) {
        this.category = category;
    }
}
