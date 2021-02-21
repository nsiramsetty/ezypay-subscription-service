package com.ezypay.subscription.service.utils;

public class Constants {
    public static final String ERROR_INVALID_SUBSCRIPTION_TYPE = "Invalid Subscription Type";
    public static final String ERROR_END_DATE_LESS_START_DATE = "End date can not be less than start date";
    public static final String ERROR_END_DATE_GREATER_3_MONTHS_START_DATE = "End date can not be more than 3 months from start date";
    public static final String ERROR_DAY_OF_MONTH_REQUIRED_MONTHLY = "Day of the Month is required when subscription Type is MONTHLY";
    public static final String ERROR_DAY_OF_WEEK_REQUIRED_WEEKLY = "Day of the week is required when subscription Type is WEEKLY";
    public static final String FAILED_EXCEPTION = "Failed to throw the expected exception";
}
