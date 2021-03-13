package by.bsu.fpmi.siachko.lab1.sportevent.events.game;

import by.bsu.fpmi.siachko.lab1.sportevent.property.attendance.Attendance;
import by.bsu.fpmi.siachko.lab1.sportevent.SportEvent;
import by.bsu.fpmi.siachko.lab1.sportevent.participant.GameParticipant;
import by.bsu.fpmi.siachko.lab1.sportevent.property.date.Date;
import by.bsu.fpmi.siachko.lab1.sportevent.property.place.Place;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Game extends SportEvent {

    @JsonProperty("gameName")
    private String gameName;
    @JsonProperty("gameParticipant1")
    private GameParticipant gameParticipant1;
    @JsonProperty("gameParticipant2")
    private GameParticipant gameParticipant2;

    public Game(Date date, Place place, Attendance attendance, String gameName, GameParticipant gameParticipant1, GameParticipant gameParticipant2) {
        super(date, place, attendance);
        this.gameName = gameName;
        this.gameParticipant1 = gameParticipant1;
        this.gameParticipant2 = gameParticipant2;
    }

    public Game()
    {

    }

    @XmlElement()
    public GameParticipant getGameParticipant1() {
        return gameParticipant1;
    }

    public void setGameParticipant1(GameParticipant gameParticipant1) {
        this.gameParticipant1 = gameParticipant1;
    }

    @XmlElement()
    public GameParticipant getGameParticipant2() {
        return gameParticipant2;
    }

    public void setGameParticipant2(GameParticipant gameParticipant2) {
        this.gameParticipant2 = gameParticipant2;
    }

    @XmlElement()
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "Event name: " + gameName + "\n"
                + super.toString()
                + "Result: "
                + gameParticipant1 + ", "
                + gameParticipant2 + "\n";
    }
}
