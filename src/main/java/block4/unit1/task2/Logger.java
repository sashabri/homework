package block4.unit1.task2;

import java.util.Date;

public class Logger {
    protected int num = 1;

    public void log(String msg) {
        Date date = new Date();
        System.out.println("[" + date + " " + num++ + "] " + msg);
    }

    private static Logger logger = null;

    private Logger() {
    }

    public static Logger getInstance() {

        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}

