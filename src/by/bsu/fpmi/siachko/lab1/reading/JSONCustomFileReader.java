package by.bsu.fpmi.siachko.lab1.reading;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONCustomFileReader extends CustomFileReader{

    private ObjectMapper mapper;

    public JSONCustomFileReader(String fileName) {
        super(fileName);
        mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
    }

    @Override
    public void write(List<SportEvent> list) throws IOException
    {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), list);
    }

    @Override
    public List<SportEvent> read() throws IOException
    {
        return mapper.readValue(new File(fileName), new TypeReference<ArrayList<SportEvent>>() {});
    }
}
