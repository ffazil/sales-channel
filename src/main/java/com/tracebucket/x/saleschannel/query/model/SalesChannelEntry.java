package com.tracebucket.x.saleschannel.query.model;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.Set;

/**
 * Created by Madhavi on 09-09-2015.
 */
@Document(indexName = "saleschannel")
public class SalesChannelEntry {
    @Id
    private String id;

    private String name;

    private String code;

    private String description;

    private SalesChannelType channelType;

    private Date startTime;

    private Date endTime;

    private Set<AddressEntry> addressEntries;

    private Set<ContactEntry> contactEntries;

    public SalesChannelEntry(){

    }

    public SalesChannelEntry(String id, String name, String code, String description,
                             SalesChannelType channelType, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.channelType = channelType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChannelType(SalesChannelType channelType) {
        this.channelType = channelType;
    }

    public String getId() {
        return id;
    }

    public SalesChannelType getChannelType() {
        return channelType;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<AddressEntry> getAddressEntry() {
        return addressEntries;
    }

    public void setAddressEntry(Set<AddressEntry> addressEntries) {
        this.addressEntries = addressEntries;
    }

    public Set<ContactEntry> getContactEntry() {
        return contactEntries;
    }

    public void setContactEntry(Set<ContactEntry> contactEntries) {
        this.contactEntries = contactEntries;
    }

    public Date getEndTime() {return endTime;   }

    public void setEndTime(Date endTime) { this.endTime = endTime;  }

    public Date getStartTime() { return startTime;    }

    public void setStartTime(Date startTime) { this.startTime = startTime;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesChannelEntry that = (SalesChannelEntry) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (channelType != that.channelType) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (addressEntries != null ? !addressEntries.equals(that.addressEntries) : that.addressEntries != null)
            return false;
        return !(contactEntries != null ? !contactEntries.equals(that.contactEntries) : that.contactEntries != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (channelType != null ? channelType.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (addressEntries != null ? addressEntries.hashCode() : 0);
        result = 31 * result + (contactEntries != null ? contactEntries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalesChannelEntry{" +
                "addressEntries=" + addressEntries +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", channelType=" + channelType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", contactEntries=" + contactEntries +
                '}';
    }
}
