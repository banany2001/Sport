package by.bsu.fpmi.siachko.lab1.sportevent.events.race;

import by.bsu.fpmi.siachko.lab1.sportevent.property.attendance.Attendance;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.property.date.Date;
import by.bsu.fpmi.siachko.lab1.sportevent.property.place.Place;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.RaceParticipant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Race extends SportEvent {

    @JsonProperty("raceName")
    private String raceName;
    @JsonProperty("raceParticipants")
    @JsonDeserialize(as = ArrayList.class)
    private ArrayList<RaceParticipant> raceParticipants;

    public Race(Date date, Place place, Attendance attendance, String raceName, ArrayList<RaceParticipant> raceParticipants) {
        super(date, place, attendance);
        this.raceName = raceName;
        this.raceParticipants = raceParticipants;
        Collections.sort(this.raceParticipants, new Comparator<RaceParticipant>() {
            @Override
            public int compare(RaceParticipant o1, RaceParticipant o2) {
                return o1.getResult().getTime().compareTo(o2.getResult().getTime());
            }
        });
    }

    public Race()
    {

    }

    @XmlElementWrapper(name = "Participants", nillable = true)
    public ArrayList<RaceParticipant> getRaceParticipants() {
        return raceParticipants;
    }

    public void setRaceParticipants(ArrayList<RaceParticipant> raceParticipants) {
        this.raceParticipants = raceParticipants;
        Collections.sort(this.raceParticipants, new Comparator<RaceParticipant>() {
            @Override
            public int compare(RaceParticipant o1, RaceParticipant o2) {
                return o1.getResult().getTime().compareTo(o2.getResult().getTime());
            }
        });
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event name: ");
        stringBuilder.append(raceName);
        stringBuilder.append("\n");
        stringBuilder.append(super.toString());
        stringBuilder.append("Participants:\n");
        for (RaceParticipant raceParticipant : raceParticipants){
            stringBuilder.append(raceParticipant);
        }
        return stringBuilder.toString();
    }
}
