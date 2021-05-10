package by.bsu.fpmi.siachko.lab1.sportevent.property.attendance;

import by.bsu.fpmi.siachko.lab1.reading.CsvIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Attendance {

    @JsonProperty("peopleUntil18")
    private int peopleUntil18;
    @JsonProperty("peopleUntil30")
    private int peopleUntil30;
    @JsonProperty("peopleUntil45")
    private int peopleUntil45;
    @JsonProperty("peopleUntil60")
    private int peopleUntil60;
    @JsonProperty("peopleAfter60")
    private int peopleAfter60;
    @JsonIgnore
    @CsvIgnore
    private int total;

    public Attendance(int peopleUntil18, int peopleUntil30, int peopleUntil45, int peopleUntil60, int peopleAfter60) {
        this.peopleUntil18 = peopleUntil18;
        this.peopleUntil30 = peopleUntil30;
        this.peopleUntil45 = peopleUntil45;
        this.peopleUntil60 = peopleUntil60;
        this.peopleAfter60 = peopleAfter60;
        this.total = peopleUntil18 + peopleUntil30 + peopleUntil45 + peopleUntil60 + peopleAfter60;
    }

    public Attendance()
    {

    }

    @XmlElement(name="until_18")
    public int getPeopleUntil18() {
        return peopleUntil18;
    }
    @XmlElement(name="until_30")
    public int getPeopleUntil30() {
        return peopleUntil30;
    }
    @XmlElement(name="until_45")
    public int getPeopleUntil45() {
        return peopleUntil45;
    }
    @XmlElement(name="until_60")
    public int getPeopleUntil60() {
        return peopleUntil60;
    }
    @XmlElement(name="after_60")
    public int getPeopleAfter60() {
        return peopleAfter60;
    }

    public int getTotal() {
        total = peopleUntil18 + peopleUntil30 + peopleUntil45 + peopleUntil60 + peopleAfter60;
        return total;
    }

    public void setPeopleUntil18(int peopleUntil18) {
        this.peopleUntil18 = peopleUntil18;
    }

    public void setPeopleUntil30(int peopleUntil30) {
        this.peopleUntil30 = peopleUntil30;
    }

    public void setPeopleUntil45(int peopleUntil45) {
        this.peopleUntil45 = peopleUntil45;
    }

    public void setPeopleUntil60(int peopleUntil60) {
        this.peopleUntil60 = peopleUntil60;
    }

    public void setPeopleAfter60(int peopleAfter60) {
        this.peopleAfter60 = peopleAfter60;
    }

    @Override
    public String toString() {
        return "\n0 - 18: " + peopleUntil18 + "\n" +
                "18 - 30: " + peopleUntil30 + "\n" +
                "30 - 45: " + peopleUntil45 + "\n" +
                "45 - 60: " + peopleUntil60 + "\n" +
                "60+: " + peopleAfter60 + "\n" +
                "Total: " + getTotal();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj.getClass() != this.getClass()){
            return false;
        }
        Attendance secondAttendance = (Attendance) obj;
        return this.peopleUntil18 == secondAttendance.peopleUntil18
                && this.peopleUntil30 == secondAttendance.peopleUntil30
                && this.peopleUntil45 == secondAttendance.peopleUntil45
                && this.peopleUntil60 == secondAttendance.peopleUntil60
                && this.peopleAfter60 == secondAttendance.peopleAfter60;
    }
}
