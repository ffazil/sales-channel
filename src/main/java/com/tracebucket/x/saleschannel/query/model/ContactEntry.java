package com.tracebucket.x.saleschannel.query.model;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

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
    private Date workTimeFrom;
    private Date workTimeTo;
    private String mobile;
    private String fax;

    public ContactEntry(){

    }

    public ContactEntry(String name, String phone, String email, String fax, String mobile,  Date workTimeFrom, Date workTimeTo) {
        this.email = email;
        this.fax = fax;
        this.mobile = mobile;
        this.name = name;
        this.phone = phone;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getWorkTimeFrom() {
        return workTimeFrom;
    }

    public void setWorkTimeFrom(Date workTimeFrom) {
        this.workTimeFrom = workTimeFrom;
    }

    public Date getWorkTimeTo() {
        return workTimeTo;
    }

    public void setWorkTimeTo(Date workTimeTo) {
        this.workTimeTo = workTimeTo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntry that = (ContactEntry) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (workTimeFrom != null ? !workTimeFrom.equals(that.workTimeFrom) : that.workTimeFrom != null) return false;
        if (workTimeTo != null ? !workTimeTo.equals(that.workTimeTo) : that.workTimeTo != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return !(fax != null ? !fax.equals(that.fax) : that.fax != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (workTimeFrom != null ? workTimeFrom.hashCode() : 0);
        result = 31 * result + (workTimeTo != null ? workTimeTo.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactEntry{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", workTimeFrom=" + workTimeFrom +
                ", workTimeTo=" + workTimeTo +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}
