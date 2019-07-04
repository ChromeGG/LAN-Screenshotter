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
}
