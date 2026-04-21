package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    FileWriter fw;
    private  Logger()
    {
        try
        {
          // true = append mode (old logs are preserved, new logs added at end)
          // without true = overwrite mode (old logs are lost on each run)
          fw=new FileWriter("logger.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance()
    {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        try {
            fw.write(message + "\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
