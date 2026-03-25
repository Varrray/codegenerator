package com.project.codegenerator.service;

import com.project.codegenerator.dto.subscription.PlanLimitResponse;
import com.project.codegenerator.dto.subscription.UsageTodayResponse;


public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimits(Long userId);
}
