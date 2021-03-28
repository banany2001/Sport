package by.bsu.fpmi.siachko.lab1.reading;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LogFile {

    private static PrintWriter printWriter;

    public LogFile() throws FileNotFoundException
    {

        Calendar calendar = new GregorianCalendar();
        StringBuilder fileName = new StringBuilder().append("log_");
        int temp = calendar.get(Calendar.DAY_OF_MONTH);
        if (temp < 10){
            fileName.append(0);
        }
        fileName.append(temp).append("-");
        temp = calendar.get(Calendar.MONTH);
        if (temp < 10){
            fileName.append(0);
        }
        fileName.append(temp).append("-");
        temp = calendar.get(Calendar.YEAR);
        fileName.append(temp).append("_");

        temp = calendar.get(Calendar.HOUR_OF_DAY);
        if (temp < 10){
            fileName.append(0);
        }
        fileName.append(temp).append("-");
        temp = calendar.get(Calendar.MINUTE);
        if (temp < 10){
            fileName.append(0);
        }
        fileName.append(temp).append("-");
        temp = calendar.get(Calendar.SECOND);
        if (temp < 10){
            fileName.append(0);
        }
        fileName.append(temp).append(".txt");
        printWriter = new PrintWriter(fileName.toString());

    }

    public static PrintWriter getPrintWriter() {
        return printWriter;
    }
}
