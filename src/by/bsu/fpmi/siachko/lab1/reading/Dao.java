package by.bsu.fpmi.siachko.lab1.reading;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface Dao <T>{
    public List<T> read() throws IOException, Exception;
    public void write(List<T> list) throws JAXBException, IOException;
}
