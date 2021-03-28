package by.bsu.fpmi.siachko.lab1.demo;

import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.events.race.Race;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement()
public class EventsList<T extends SportEvent> {

    private List<T> list;

    public EventsList() {
        list = null;
    }

    @XmlElement()
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
