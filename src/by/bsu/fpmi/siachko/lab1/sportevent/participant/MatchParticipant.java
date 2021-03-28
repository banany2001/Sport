package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MatchParticipant extends Participant{

    @JsonProperty("result")
    private boolean result;

    public MatchParticipant(String name, boolean result) {
        super(name);
        this.result = result;
    }

    public MatchParticipant()
    {

    }

    public String getName() {
        return name;
    }

    @XmlElement
    public boolean isResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        String ans = name;
        if (result){
            ans += " won";
        }
        else {
            ans += " lost";
        }
        return ans;
    }
}
