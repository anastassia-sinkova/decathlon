package com.industry62.decathlon.service;

import com.industry62.decathlon.domain.Event;
import com.industry62.decathlon.domain.EventScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    public int calculateTotalScore(List<EventScore> eventScores) {
        return eventScores.stream()
                .mapToInt(ScoreService::calculateEventScore)
                .sum();
    }

    static int calculateEventScore(EventScore eventScore) {
        Event event = eventScore.getEvent();
        double score = eventScore.getScore();

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

}
