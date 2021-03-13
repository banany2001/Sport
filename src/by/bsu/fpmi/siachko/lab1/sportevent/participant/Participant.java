package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import by.bsu.fpmi.siachko.lab1.sportevent.events.match.Match;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="Participant")
@XmlSeeAlso({RaceParticipant.class, GameParticipant.class, MatchParticipant.class})
public abstract class Participant {

    @JsonProperty("name")
    protected String name;

    public Participant(String name) {
        this.name = name;
    }

    public Participant()
    {

    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
