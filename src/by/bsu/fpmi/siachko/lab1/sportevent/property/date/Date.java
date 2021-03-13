package by.bsu.fpmi.siachko.lab1.sportevent.property.date;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Date {

    @JsonProperty("dayOfWeek")
    String dayOfWeek;
    @JsonProperty("day")
    int day;
    @JsonProperty("month")
    int month;
    @JsonProperty("year")
    int year;

    public Date(String dayOfWeek, int day, int month, int year) {
        this.dayOfWeek = dayOfWeek;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date()
    {

    }

    @XmlElement
    public String getDayOfWeek() {
        return dayOfWeek.toString();
    }

    @XmlElement
    public int getDay() {
        return day;
    }

    @XmlElement
    public int getMonth() {
        return month;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return dayOfWeek + ", "
                + day + "/"
                + month + "/"
                + year;
    }
}
