package by.bsu.fpmi.siachko.lab1.sportevent;

import by.bsu.fpmi.siachko.lab1.sportevent.events.game.Game;
import by.bsu.fpmi.siachko.lab1.sportevent.events.match.Match;
import by.bsu.fpmi.siachko.lab1.sportevent.events.race.Race;
import by.bsu.fpmi.siachko.lab1.sportevent.property.attendance.Attendance;
import by.bsu.fpmi.siachko.lab1.sportevent.property.date.Date;
import by.bsu.fpmi.siachko.lab1.sportevent.property.place.Place;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "Event")
@XmlSeeAlso({Race.class, Match.class, Game.class})
public abstract class SportEvent {

    @JsonProperty("date")
    Date date;
    @JsonProperty("place")
    Place place;
    @JsonProperty("attendance")
    Attendance attendance;

    public SportEvent(Date date, Place place, Attendance attendance) {
        this.date = date;
        this.place = place;
        this.attendance = attendance;
    }

    public SportEvent()
    {

    }

    @XmlElement()
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlElement()
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @XmlElement()
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Date : " + date + "\n"
                + "Place: " + place + "\n"
                + "Attendance: " + attendance + "\n";
    }
}
