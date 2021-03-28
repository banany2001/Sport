package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class JsonDao<T extends SportEvent> extends AbstractDao<T> {

    private ObjectMapper mapper;

    private JsonDao(String fileName) {
        super(fileName);
        mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
    }

    public static <T> Dao<T> create(String fileName, Class<?> aClass)
    {
        return (Dao<T>) Proxy.newProxyInstance(
                aClass.getClassLoader(),
                new Class[]{Dao.class},
                new LoggingProxyHandler<>(new JsonDao(fileName))
        );
    }

    @Override
    public void write(List<T> list) throws IOException
    {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), list);
    }

    @Override
    public List<T> read() throws IOException
    {
        return mapper.readValue(new File(fileName), new TypeReference<ArrayList<T>>() {});
    }
}
