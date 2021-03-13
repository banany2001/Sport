package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GameParticipant extends Participant{

    @JsonProperty("points")
    private int points;

    public GameParticipant(String name, int points) {
        super(name);
        this.points = points;
    }

    public GameParticipant()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return name + " got " + points;
    }
}
