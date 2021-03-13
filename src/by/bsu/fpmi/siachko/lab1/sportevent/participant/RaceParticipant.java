package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class RaceParticipant extends Participant{

    @JsonProperty("result")
    private Result result;

    public RaceParticipant(String name, Result result) {
        super(name);
        this.result = result;
    }

    public RaceParticipant()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Name: " + super.toString()
                + ", Result: " + result + "\n";
    }
}
