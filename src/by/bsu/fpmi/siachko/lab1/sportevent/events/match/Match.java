package by.bsu.fpmi.siachko.lab1.sportevent.events.match;

import by.bsu.fpmi.siachko.lab1.sportevent.property.attendance.Attendance;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.MatchParticipant;
import by.bsu.fpmi.siachko.lab1.sportevent.property.date.Date;
import by.bsu.fpmi.siachko.lab1.sportevent.property.place.Place;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Match extends SportEvent {

    @JsonProperty("matchName")
    private String matchName;
    @JsonProperty("matchParticipant1")
    private MatchParticipant matchParticipant1;
    @JsonProperty("matchParticipant2")
    private MatchParticipant matchParticipant2;

    public Match(Date date, Place place, Attendance attendance, String matchName, MatchParticipant matchParticipant1, MatchParticipant matchParticipant2) {
        super(date, place, attendance);
        this.matchName = matchName;
        this.matchParticipant1 = matchParticipant1;
        this.matchParticipant2 = matchParticipant2;
    }

    public Match()
    {

    }

    @XmlElement
    public MatchParticipant getMatchParticipant1() {
        return matchParticipant1;
    }

    public void setMatchParticipant1(MatchParticipant matchParticipant1) {
        this.matchParticipant1 = matchParticipant1;
    }

    @XmlElement
    public MatchParticipant getMatchParticipant2() {
        return matchParticipant2;
    }

    public void setMatchParticipant2(MatchParticipant matchParticipant2) {
        this.matchParticipant2 = matchParticipant2;
    }

    @XmlElement
    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    @Override
    public String toString() {
        return "Event name:" + matchName + "\n"
                + super.toString()
                + "Result: "
                + matchParticipant1 +
                ", " + matchParticipant2 + "\n";
    }
}
