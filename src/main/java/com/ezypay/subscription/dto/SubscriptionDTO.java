package com.ezypay.subscription.dto;

import com.ezypay.subscription.model.SubscriptionDays;
import com.ezypay.subscription.model.SubscriptionType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SubscriptionDTO {

    @NotNull
    private Double amount;

    @NotNull
    private SubscriptionType subscriptionType;

    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private Date startDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    @NotNull
    private Date endDate;

    @Max(28)
    @Min(1)
    private Integer dayOfTheMonth;

    private SubscriptionDays dayOfTheWeek;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SubscriptionDays getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(SubscriptionDays dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Integer getDayOfTheMonth() {
        return dayOfTheMonth;
    }

    public void setDayOfTheMonth(Integer dayOfTheMonth) {
        this.dayOfTheMonth = dayOfTheMonth;
    }
}
