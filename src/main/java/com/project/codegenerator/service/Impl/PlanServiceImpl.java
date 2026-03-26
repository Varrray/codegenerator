package com.project.codegenerator.service.Impl;

import com.project.codegenerator.dto.subscription.PlanResponse;
import com.project.codegenerator.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
