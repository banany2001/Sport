package by.bsu.fpmi.siachko.lab1.sportevent.participant;

import by.bsu.fpmi.siachko.lab1.reading.CsvIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.regex.Pattern;

@XmlRootElement
public class Result {

    @JsonProperty("time")
    private String time;

    @CsvIgnore
    private Pattern pattern = Pattern.compile("\\d{2}:[0-5]\\d:[0-5]\\d,\\d{3}");

    public Result(String time) throws Exception{
        if (pattern.matcher(time).find()){
            this.time = time;
        }
        else {
            throw new Exception();
        }
    }

    //Pattern.matches("\\d{2}:[0-5]\\d:[0-5]\\d,\\d{3}", time)

    public Result()
    {

    }

    @XmlElement
    public String getTime() {
        return time;
    }

    public void setTime(String time) throws Exception{
        if (pattern.matcher(time).find()){
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
