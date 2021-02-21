package com.ezypay.subscription.entity;
import com.ezypay.subscription.model.SubscriptionDays;
import com.ezypay.subscription.model.SubscriptionType;

import java.util.Date;
import java.util.List;

public class Subscription {

    Double amount;

    private Date startDate;

    private Date endDate;

    private Integer dayOfTheMonth;

    private SubscriptionDays dayOfTheWeek;

    private SubscriptionType subscriptionType;

    private List<Date> invoiceDates;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getDayOfTheMonth() {
        return dayOfTheMonth;
    }

    public void setDayOfTheMonth(Integer dayOfTheMonth) {
        this.dayOfTheMonth = dayOfTheMonth;
    }

    public SubscriptionDays getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(SubscriptionDays dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
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

    public List<Date> getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(List<Date> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }

}
