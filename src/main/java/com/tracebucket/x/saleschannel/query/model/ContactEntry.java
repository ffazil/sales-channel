package com.tracebucket.x.saleschannel.query.model;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Madhavi on 09-09-2015.
 */
@Document(indexName = "contact")
public class ContactEntry {
/*
    @Id
    private String id;
*/

    private String name;
    private String phone;
    private String email;
    private String mobile;
    private String fax;

    public ContactEntry(){

    }

   /* public AddressEntry(String id, String name, String description, SalesChannelType channelType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.channelType = channelType;
    }*/

   /* public void setId(String id) {
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
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntry salesChannelEntry = (ContactEntry) o;

        /*if (completed != SalesChannel.completed) return false;
        if (starred != SalesChannel.starred) return false;
        */
      /*  if (!id.equals(salesChannelEntry.id)) return false;
        if (!name.equals(salesChannelEntry.name)) return false;
        return description.equals(salesChannelEntry.description);*/
        return true;
    }

    @Override
    public int hashCode() {
        Integer id=21;
        int result = id.hashCode();
/*
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (channelType.hashCode());
*/
        return result;
    }

    @Override
    public String toString() {
        return "SalesChannel{" +
/*
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", channelType=" + channelType+
*/
                '}';
    }
}
