package by.bsu.fpmi.siachko.lab1.sportevent.property.place;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Place {

    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("address")
    private String address;

    public Place(String country, String region, String locality, String zipCode, String address) {
        this.country = country;
        this.region = region;
        this.locality = locality;
        this.zipCode = zipCode;
        this.address = address;
    }

    public Place()
    {

    }

    @XmlElement
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlElement
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @XmlElement
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return zipCode + ", "
                + country + ", "
                + region + ", "
                + locality + ", "
                + address;
    }
}
