package com.tracebucket.x.saleschannel.query.model;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Madhavi on 09-09-2015.
 */
@Document(indexName = "saleschannel", type = "saleschannelentry")
public class SalesChannelEntry {
    @Id
    private String id;

    private String name;

    private String description;

    private SalesChannelType channelType;

    public SalesChannelEntry(){

    }

    public SalesChannelEntry(String id, String name, String description, SalesChannelType channelType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.channelType = channelType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesChannelEntry salesChannelEntry = (SalesChannelEntry) o;

        /*if (completed != SalesChannel.completed) return false;
        if (starred != SalesChannel.starred) return false;
        */
        if (!id.equals(salesChannelEntry.id)) return false;
        if (!name.equals(salesChannelEntry.name)) return false;
        return description.equals(salesChannelEntry.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (channelType.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SalesChannel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", channelType=" + channelType+
                '}';
    }
}
