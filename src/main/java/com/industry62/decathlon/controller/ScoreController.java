package com.industry62.decathlon.controller;

import com.industry62.decathlon.domain.EventScore;
import com.industry62.decathlon.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class ScoreController {
    private ScoreService scoreService;

    @PostMapping("/total-score")
    public int calculateTotalScore(@RequestBody List<@Valid EventScore> eventScores) {
        return scoreService.calculateTotalScore(eventScores);
    }

}
