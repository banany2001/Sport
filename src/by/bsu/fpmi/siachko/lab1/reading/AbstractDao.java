package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractDao<T extends SportEvent> implements Dao<T>{

    protected String fileName;

    public AbstractDao(String fileName) {
        this.fileName = fileName;
    }

    public abstract List<T> read() throws IOException, Exception;
    public abstract void write(List<T> list) throws JAXBException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;


}
