package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.regex.Pattern;

@XmlRootElement
public class Result {

    @JsonProperty("time")
    private String time;

    public Result(String time) throws Exception{
        if (Pattern.matches("\\d{2}:[0-5]\\d:[0-5]\\d,[0-5]\\d", time)){
            this.time = time;
        }
        else {
            throw new Exception();
        }
    }

    public Result()
    {

    }

    @XmlElement
    public String getTime() {
        return time;
    }

    public void setTime(String time) throws Exception{
        if (Pattern.matches("\\d{2}:[0-5]\\d:[0-5]\\d,[0-5]\\d", time)){
            this.time = time;
        }
        else {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return time;
    }
}
