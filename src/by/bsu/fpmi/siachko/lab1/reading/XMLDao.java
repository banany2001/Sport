package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.demo.EventsList;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.lang.reflect.Proxy;
import java.util.List;

public class XMLDao<T extends SportEvent> extends AbstractDao<T> {

    private JAXBContext context;
    private Marshaller marshaller;
    Class<T> tClass;

    private XMLDao(String fileName, Class<T> tClass) throws JAXBException {
        super(fileName);
        context = JAXBContext.newInstance(tClass, EventsList.class);
        marshaller= context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    public static <T> Dao<T> create(String fileName, Class<T> tClass, Class<?> aClass) throws JAXBException
    {
        return (Dao<T>) Proxy.newProxyInstance(
                aClass.getClassLoader(),
                new Class[]{Dao.class},
                new LoggingProxyHandler<>(new XMLDao(fileName, tClass))
        );
    }

    @Override
    public void write(List<T> list) throws JAXBException {
        EventsList<T> metaList = new EventsList<>();
        metaList.setList(list);
        marshaller.marshal(metaList, new File(fileName));
    }

    @Override
    public List<T> read() throws JAXBException
    {
        return ((EventsList<T>) context.createUnmarshaller().unmarshal(new File(fileName))).getList();
    }

}
