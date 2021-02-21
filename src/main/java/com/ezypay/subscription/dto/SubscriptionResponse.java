package com.ezypay.subscription.dto;

import com.ezypay.subscription.entity.Subscription;
import com.ezypay.subscription.model.SubscriptionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class SubscriptionResponse {

    private Double amount;

    @JsonFormat(pattern="dd/MM/yyyy")
    private List<Date> invoiceDates;

    private SubscriptionType subscriptionType;

    public List<Date> getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(List<Date> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }

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

    public SubscriptionResponse(Subscription subscription){
        this.invoiceDates = subscription.getInvoiceDates();
        this.amount = subscription.getAmount();
        this.subscriptionType = subscription.getSubscriptionType();
    }
}
