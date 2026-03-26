package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.subscription.PlanLimitResponse;
import com.project.codegenerator.dto.subscription.UsageTodayResponse;
import com.project.codegenerator.service.UsageService;
import org.springframework.stereotype.Service;


@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimits(Long userId) {
        return null;
    }
}
