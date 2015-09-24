package com.tracebucket.x.saleschannel.query.model;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Madhavi on 09-09-2015.
 */
@Document(indexName = "address")
public class AddressEntry {
/*
    @Id
    private String id;
*/

    private  String line1;
    private  String line2;
    private  String city;


    private  String state;
    private  String country;
    private  String pincode;
    private  String website;

    public AddressEntry(){

    }

    public AddressEntry(String line1, String line2, String city, String state, String country, String pincode, String website) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntry that = (AddressEntry) o;

        if (line1 != null ? !line1.equals(that.line1) : that.line1 != null) return false;
        if (line2 != null ? !line2.equals(that.line2) : that.line2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (pincode != null ? !pincode.equals(that.pincode) : that.pincode != null) return false;
        return !(website != null ? !website.equals(that.website) : that.website != null);

    }

    @Override
    public int hashCode() {
        int result = line1 != null ? line1.hashCode() : 0;
        result = 31 * result + (line2 != null ? line2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (pincode != null ? pincode.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressEntry{" +
                "city='" + city + '\'' +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                ", website='" + website + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
