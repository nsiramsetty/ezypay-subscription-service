package com.ezypay.subscription.service.subscription;

import com.ezypay.subscription.model.SubscriptionType;
import com.ezypay.subscription.service.exception.SubscriptionException;
import com.ezypay.subscription.service.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ezypay.subscription.dto.SubscriptionDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest(SubscriptionService.class)
public class SubscriptionServiceTest {

    @TestConfiguration
    static class SubscriptionServiceTestContextConfiguration {
        @Bean
        public SubscriptionService accountService() {
            return new SubscriptionService();
        }
    }

    @Before
    public void setUp()
    {
        PowerMockito.mockStatic(SubscriptionService.class);
    }

    @Autowired
    private SubscriptionService subscriptionService;

    @MockBean
    private ObjectMapper mapper;

    @Test
    public void inValidSubscriptionType() throws IOException {
        SubscriptionDTO params = new SubscriptionDTO();
        params.setAmount(10.00);
        params.setStartDate(new Date("01/01/2021"));
        params.setEndDate(new Date("01/04/2021"));
        try {
            subscriptionService.createSubscription(params);
        } catch (SubscriptionException e) {
            assertThat(e.getMessage()).isEqualTo(Constants.ERROR_INVALID_SUBSCRIPTION_TYPE);
            return;
        }
        fail("Failed to throw the expected exception");
    }

    @Test
    public void startDateShouldBeLessThanEndDate() throws IOException {
        SubscriptionDTO params = new SubscriptionDTO();
        String nzCurrency = "nzd";
        params.setAmount(10.00);
        params.setStartDate(new Date("01/01/2021"));
        params.setEndDate(new Date("01/04/2020"));
        params.setSubscriptionType(SubscriptionType.WEEKLY);
        try {
            subscriptionService.createSubscription(params);
        } catch (SubscriptionException e) {
            assertThat(e.getMessage()).isEqualTo(Constants.ERROR_END_DATE_LESS_START_DATE);
            return;
        }
        fail(Constants.FAILED_EXCEPTION);
    }

    @Test
    public void endDateCannotBeMoreThan3MonthsFromStartDate() throws IOException {
        SubscriptionDTO params = new SubscriptionDTO();
        String nzCurrency = "nzd";
        params.setAmount(10.00);
        params.setStartDate(new Date("01/01/2021"));
        params.setEndDate(new Date("01/04/2022"));
        params.setSubscriptionType(SubscriptionType.WEEKLY);
        try {
            subscriptionService.createSubscription(params);
        } catch (SubscriptionException e) {
            assertThat(e.getMessage()).isEqualTo(Constants.ERROR_END_DATE_GREATER_3_MONTHS_START_DATE);
            return;
        }
        fail(Constants.FAILED_EXCEPTION);
    }

    @Test
    public void whenSubscriptionTypeIsWeeklyDayOfTheWeekIsRequired() throws IOException {
        SubscriptionDTO params = new SubscriptionDTO();
        String nzCurrency = "nzd";
        params.setAmount(10.00);
        params.setStartDate(new Date("01/01/2021"));
        params.setEndDate(new Date("01/04/2021"));
        params.setSubscriptionType(SubscriptionType.WEEKLY);
        try {
            subscriptionService.createSubscription(params);
        } catch (SubscriptionException e) {
            assertThat(e.getMessage()).isEqualTo(Constants.ERROR_DAY_OF_WEEK_REQUIRED_WEEKLY);
            return;
        }
        fail(Constants.FAILED_EXCEPTION);
    }

    @Test
    public void whenSubscriptionTypeIsMonthlyDayOfTheMonthIsRequired() throws IOException {
        SubscriptionDTO params = new SubscriptionDTO();
        String nzCurrency = "nzd";
        params.setAmount(10.00);
        params.setStartDate(new Date("01/01/2021"));
        params.setEndDate(new Date("01/04/2021"));
        params.setSubscriptionType(SubscriptionType.MONTHLY);
        try {
            subscriptionService.createSubscription(params);
        } catch (SubscriptionException e) {
            assertThat(e.getMessage()).isEqualTo(Constants.ERROR_DAY_OF_MONTH_REQUIRED_MONTHLY);
            return;
        }
        fail(Constants.FAILED_EXCEPTION);
    }
}
