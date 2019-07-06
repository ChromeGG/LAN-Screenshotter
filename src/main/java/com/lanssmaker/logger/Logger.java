package com.lanssmaker.logger;

import com.lanssmaker.logger.log.LOG_CATEGORIES;
import com.lanssmaker.logger.log.Log;
import javafx.collections.ObservableList;

public class Logger {
    private ObservableList<Log> logsList;

    public Logger(ObservableList<Log> logsList) {
        this.logsList = logsList;
    }

    public void addTestLog(){
        logsList.add(new Log("21:37", "Papor zdeh", LOG_CATEGORIES.INFO));
    }
}
