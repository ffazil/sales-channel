package com.tracebucket.x.saleschannel.domain.command;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Madhavi on 09-09-2015.
 */
public class AddSalesChannelContactCommand {

    @NotNull
    private final String salesChannelid;

    @NotNull
    private final String name;

    @NotNull
    private final String phone;

    @NotNull
    private final String email;

    @NotNull
    private final Date workTimeFrom;

    @NotNull
    private final Date workTimeTo;

    @NotNull
    private final String mobile;

    @NotNull
    private final String fax;




    public AddSalesChannelContactCommand(String salesChannelid, String name, String phone, String email, String mobile, String fax, Date workTimeFrom, Date workTimeTo ) {
        this.email = email;
        this.salesChannelid = salesChannelid;
        this.name = name;
        this.phone = phone;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.mobile = mobile;
        this.fax = fax;
    }


    public String getSalesChannelid() {
        return salesChannelid;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getMobile() {
        return mobile;
    }

    public Date getWorkTimeFrom() {
        return workTimeFrom;
    }

    public Date getWorkTimeTo() {
        return workTimeTo;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


}
