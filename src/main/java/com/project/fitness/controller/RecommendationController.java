package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;
    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request){
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>>getUserRecommendation(
            @PathVariable String userId){
        List<Recommendation> recommendationList = recommendationService.getuserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>>getActivityRecommendation(
            @PathVariable String activityId){
        List<Recommendation> recommendationList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }
}
