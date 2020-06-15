package com.industry62.decathlon.service;

import com.industry62.decathlon.domain.Event;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScoreService {

    public int calculateTotalScore(Map<Event, Double> scores) {
        return scores.entrySet().stream()
                .filter(this::isValid)
                .mapToInt(e -> calculateEventScore(e.getKey(), e.getValue()))
                .sum();
    }

    static int calculateEventScore(Event event, double score) {
        switch (event) {
            case METRES_100:
            case METRES_400:
            case METRES_110_HURDLES:
            case METRES_1500:
                return (int) (event.A * Math.pow((event.B - score), event.C));
            case SHOT_PUT:
            case DISCUS_THROW:
            case JAVELIN_THROW:
                return (int) (event.A * Math.pow((score - event.B), event.C));
            case LONG_JUMP:
            case HIGH_JUMP:
            case POLE_VAULT:
                score = convertMetresToCentimetres(score);
                return (int) (event.A * Math.pow((score - event.B), event.C));
            default:
                System.out.println("WARNING: Service and domain are out of sync, unknown event used: " + event);
                return 0;
        }
    }

    static double convertMetresToCentimetres(double score) {
        return score * 100;
    }

    private boolean isValid(Map.Entry<Event, Double> score) {
        return score.getValue() != null
                && score.getKey() != null;
    }

}
