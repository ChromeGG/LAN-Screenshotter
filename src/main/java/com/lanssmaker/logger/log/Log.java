package com.lanssmaker.logger.log;

import java.time.LocalDateTime;


public class Log {
    private String time;
    private String logContent;
    private LOG_CATEGORIES category;

    public Log(String logContent, LOG_CATEGORIES category) {

        this.time = createTime();
        this.logContent = logContent;
        this.category = category;
    }

    private String createTime() {
        StringBuilder stringBuilder = new StringBuilder();

        String hour = String.valueOf(LocalDateTime.now().getHour());

        //when hour number is one digit number, time is displayed such as 9:9, not 09:9
        if (hour.length() == 1) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hour);
        stringBuilder.append(":");

        String minute = String.valueOf(LocalDateTime.now().getMinute());
        //when minute number is one digit number, time is displayed such as 09:9, not 09:09
        if (minute.length() == 1) {
            stringBuilder.append(0);
        }
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
