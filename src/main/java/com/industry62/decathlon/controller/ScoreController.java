package com.industry62.decathlon.controller;

import com.industry62.decathlon.domain.Event;
import com.industry62.decathlon.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ScoreController {
    private ScoreService scoreService;

    @PostMapping("/total-score")
    public int calculateTotalScore(@Valid @RequestBody Map<Event, Double> scores) {
        return scoreService.calculateTotalScore(scores);
    }

}
