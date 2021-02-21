package com.ezypay.subscription.web.rest;

import com.ezypay.subscription.dto.SubscriptionDTO;
import com.ezypay.subscription.dto.SubscriptionResponse;
import com.ezypay.subscription.service.exception.SubscriptionException;
import com.ezypay.subscription.service.subscription.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//@CrossOrigin
@RestController
@RequestMapping("/api")
public class SubscriptionResource {

    private final Logger log = LoggerFactory.getLogger(SubscriptionResource.class);

    @Inject
    SubscriptionService subscriptionService;

    /**
     * POST /create a new account
     *
     * @return
     */

    @RequestMapping(value = "/subscriptions",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@Valid @RequestBody SubscriptionDTO subscriptionParams)
            throws URISyntaxException, IOException, SubscriptionException {

        log.debug("REST request to create an account : {}", subscriptionParams);
        SubscriptionResponse subscription = subscriptionService.createSubscription(subscriptionParams);
        log.info(subscription.toString());
        return ResponseEntity.created(new URI("/api/subscriptions/")).body(subscription);
    }
}
