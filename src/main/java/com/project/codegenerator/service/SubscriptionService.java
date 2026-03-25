package com.project.codegenerator.service;

import com.project.codegenerator.dto.subscription.CheckoutRequest;
import com.project.codegenerator.dto.subscription.CheckoutResponse;
import com.project.codegenerator.dto.subscription.PortalResponse;
import com.project.codegenerator.dto.subscription.SubscriptionResponse;


public interface SubscriptionService {


    SubscriptionResponse getMySubscription(Long userId);

    CheckoutResponse createCheckoutResponse(Long userId, CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);
}
