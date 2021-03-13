package by.bsu.fpmi.siachko.lab1.demo;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.events.race.Race;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement()
public class EventsList {

    private List<SportEvent> list;

    public EventsList() {
        list = null;
    }

    @XmlElement()
    public List<SportEvent> getList() {
        return list;
    }

    public void setList(List<SportEvent> list) {
        this.list = list;
    }
}
