package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public abstract class CustomFileReader {

    protected String fileName;

    public CustomFileReader(String fileName) {
        this.fileName = fileName;
    }

    public abstract List<SportEvent> read() throws IOException, Exception;
    public abstract void write(List<SportEvent> list) throws JAXBException, IOException;


}
