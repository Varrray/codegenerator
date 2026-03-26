package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.subscription.CheckoutRequest;
import com.project.codegenerator.dto.subscription.CheckoutResponse;
import com.project.codegenerator.dto.subscription.PortalResponse;
import com.project.codegenerator.dto.subscription.SubscriptionResponse;
import com.project.codegenerator.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getMySubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutResponse(Long userId, CheckoutRequest request) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
