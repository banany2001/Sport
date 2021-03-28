package by.bsu.fpmi.siachko.lab1.reading;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LoggingProxyHandler<T extends AbstractDao> implements InvocationHandler {

    private final T target;
    private final PrintWriter printWriter;

    public LoggingProxyHandler(T target) {
        this.target = target;
        this.printWriter = LogFile.getPrintWriter();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        printWriter.print(new Date() + ": ");
        if (method.getName().equals("read")){
            printWriter.println("invoke method read");
        }
        else if (method.getName().equals("write")){
            printWriter.println("invoke method write");
        }
        printWriter.flush();
        return method.invoke(target, args);
    }
}
