package com.lanssmaker.logger.log;

import java.time.LocalDateTime;

public class Log {
    private String time;
    private String logContent;
    private LOG_CATEGORIES category;

    public Log(String logContent, LOG_CATEGORIES category) {

        this.time = createTimeString();
        this.logContent = logContent;
        this.category = category;
    }

    private  String createTimeString() {
        StringBuilder stringBuilder = new StringBuilder();
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        stringBuilder.append(hour);
        stringBuilder.append(":");
        stringBuilder.append(minute);
        return stringBuilder.toString();
    }

    public String getTime() {
        return time;
    }

    public String getLogContent() {
        return logContent;
    }

    public LOG_CATEGORIES getCategory() {
        return category;
    }
}
