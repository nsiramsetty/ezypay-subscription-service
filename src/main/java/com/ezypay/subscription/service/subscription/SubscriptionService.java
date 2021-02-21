package com.ezypay.subscription.service.subscription;
import com.ezypay.subscription.entity.Subscription;
import com.ezypay.subscription.dto.SubscriptionDTO;
import com.ezypay.subscription.dto.SubscriptionResponse;
import com.ezypay.subscription.model.SubscriptionDays;
import com.ezypay.subscription.model.SubscriptionType;
import com.ezypay.subscription.service.exception.SubscriptionException;
import com.ezypay.subscription.service.utils.Constants;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {

    private final Logger log = LoggerFactory.getLogger(SubscriptionService.class);

    /**
     * Create Subscription
     *
     * @return Subscription Response
     */
    public SubscriptionResponse createSubscription(SubscriptionDTO params) throws SubscriptionException {
        Subscription subscription = new Subscription();
        subscription.setAmount(params.getAmount());
        subscription.setStartDate(params.getStartDate());
        subscription.setEndDate(params.getEndDate());
        subscription.setSubscriptionType(params.getSubscriptionType());
        Calendar cal = Calendar.getInstance();
        cal.setTime(subscription.getStartDate());
        LocalDate startDate = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        cal.setTime(subscription.getEndDate());
        LocalDate endDate = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE));
        if(endDate.isBefore(startDate)){
            throw new SubscriptionException(Constants.ERROR_END_DATE_LESS_START_DATE);
        }
        if(endDate.isAfter(startDate.plusMonths(3))){
            throw new SubscriptionException(Constants.ERROR_END_DATE_GREATER_3_MONTHS_START_DATE);
        }
        if(subscription.getSubscriptionType() == SubscriptionType.DAILY){
            List<Date> invoiceDates = new ArrayList<Date>();
            while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                invoiceDates.add(startDate.toDate());
                startDate = startDate.plusDays(1);
            }
            subscription.setInvoiceDates(invoiceDates);
        } else if(subscription.getSubscriptionType() == SubscriptionType.WEEKLY){
            if(params.getDayOfTheWeek() == null){
                throw new SubscriptionException(Constants.ERROR_DAY_OF_WEEK_REQUIRED_WEEKLY);
            }
            subscription.setDayOfTheWeek(params.getDayOfTheWeek());
            LocalDate firstOccurrence = startDate.withDayOfWeek(SubscriptionDays.valueOf(subscription.getDayOfTheWeek().toString()).ordinal()+1);
            List<Date> invoiceDates = new ArrayList<>();
            if (startDate.isAfter(firstOccurrence)) {
                startDate = firstOccurrence.plusWeeks(1);
            } else {
                startDate = firstOccurrence;
            }
            while (startDate.isBefore(endDate)  || startDate.isEqual(endDate)) {
                invoiceDates.add(startDate.toDate());
                startDate = startDate.plusWeeks(1);
            }
            subscription.setInvoiceDates(invoiceDates);
        }else if(subscription.getSubscriptionType() == SubscriptionType.MONTHLY){
            if(params.getDayOfTheMonth() == null){
                throw new SubscriptionException(Constants.ERROR_DAY_OF_MONTH_REQUIRED_MONTHLY);
            }
            subscription.setDayOfTheMonth(params.getDayOfTheMonth());
            LocalDate firstOccurrence = startDate.withDayOfMonth(subscription.getDayOfTheMonth());
            List<Date> invoiceDates = new ArrayList<Date>();
            if (startDate.isAfter(firstOccurrence)) {
                startDate = firstOccurrence.plusMonths(1).withDayOfMonth(subscription.getDayOfTheMonth());
            } else {
                startDate = firstOccurrence;
            }
            while (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
                invoiceDates.add(startDate.toDate());
                log.info(startDate.toString());
                startDate = startDate.plusMonths(1).withDayOfMonth(subscription.getDayOfTheMonth());
            }
            subscription.setInvoiceDates(invoiceDates);
        } else{
            throw new SubscriptionException(Constants.ERROR_INVALID_SUBSCRIPTION_TYPE);
        }
        return  generateResponse(subscription);
    }

    private SubscriptionResponse generateResponse(final Subscription subscription) {
        SubscriptionResponse resp = new SubscriptionResponse(subscription);
        return resp;
    }
}
