package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.demo.EventsList;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.events.race.Race;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XMLCustomFileReader extends CustomFileReader{

    private JAXBContext context;
    private Marshaller marshaller;

    public XMLCustomFileReader(String fileName) throws JAXBException {
        super(fileName);
        context = JAXBContext.newInstance(EventsList.class);
        marshaller= context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    @Override
    public void write(List<SportEvent> list) throws JAXBException {
        EventsList metaList = new EventsList();
        metaList.setList(list);
        marshaller.marshal(metaList, new File(fileName));
    }

    @Override
    public List<SportEvent> read() throws JAXBException
    {
        return ((EventsList) context.createUnmarshaller().unmarshal(new File(fileName))).getList();
    }

}
