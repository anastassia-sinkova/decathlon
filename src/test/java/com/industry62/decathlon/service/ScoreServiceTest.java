package com.industry62.decathlon.service;

import com.industry62.decathlon.domain.Event;
import com.industry62.decathlon.domain.EventScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreServiceTest {

    @InjectMocks
    ScoreService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldCalculateFullTotalPoints() {
        List<EventScore> scores = new ArrayList<>();

        scores.add(new EventScore(Event.METRES_100, 10.81));
        scores.add(new EventScore(Event.LONG_JUMP, 7.6));
        scores.add(new EventScore(Event.SHOT_PUT, 15.76));
        scores.add(new EventScore(Event.HIGH_JUMP, 2.04));
        scores.add(new EventScore(Event.METRES_400, 48.28));
        scores.add(new EventScore(Event.METRES_110_HURDLES, 14.02));
        scores.add(new EventScore(Event.DISCUS_THROW, 46.78));
        scores.add(new EventScore(Event.POLE_VAULT, 5.4));
        scores.add(new EventScore(Event.JAVELIN_THROW, 65.04));
        scores.add(new EventScore(Event.METRES_1500, 4 * 60 + 25.49));

        int actual = service.calculateTotalScore(scores);

        assertEquals(8834, actual);
    }

    @Test
    void shouldCalculatePartialTotalPoints() {
        List<EventScore> scores = new ArrayList<>();

        scores.add(new EventScore(Event.METRES_100, 10.81));

        scores.add(new EventScore(Event.SHOT_PUT, 15.76));
        scores.add(new EventScore(Event.HIGH_JUMP, 2.04));
        scores.add(new EventScore(Event.METRES_400, 48.28));
        scores.add(new EventScore(Event.METRES_110_HURDLES, 14.02));

        scores.add(new EventScore(Event.POLE_VAULT, 5.4));
        scores.add(new EventScore(Event.JAVELIN_THROW, 65.04));

        int actual = service.calculateTotalScore(scores);

        assertEquals(6296, actual);
    }

    @Test
    void shouldCalculate100MetresScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.METRES_100, 10.46));
        assertEquals(985, actual);
    }

    @Test
    void shouldCalculateLongJumpScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.LONG_JUMP, 7.94));
        assertEquals(1045, actual);
    }

    @Test
    void shouldCalculateShotPutScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.SHOT_PUT, 14.73));
        assertEquals(773, actual);
    }

    @Test
    void shouldCalculateHighJumpScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.HIGH_JUMP, 2.01));
        assertEquals(813, actual);
    }

    @Test
    void shouldCalculate400MetresScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.METRES_400, 46.07));
        assertEquals(1005, actual);
    }

    @Test
    void shouldCalculate110MetresHurdlesScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.METRES_110_HURDLES, 13.8));
        assertEquals(1000, actual);
    }

    @Test
    void shouldCalculateDiscusThrowScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.DISCUS_THROW, 45.49));
        assertEquals(777, actual);
    }

    @Test
    void shouldCalculatePoleVaultScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.POLE_VAULT, 5.2));
        assertEquals(972, actual);
    }

    @Test
    void shouldCalculateJavelinThrowScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.JAVELIN_THROW, 59.77));
        assertEquals(734, actual);
    }

    @Test
    void shouldCalculate1500MetresScore() {
        int actual = ScoreService.calculateEventScore(new EventScore(Event.METRES_1500, 263.33));
        assertEquals(789, actual);
    }

    @Test
    void convertMetresToCentimetres() {
        assertEquals(138, ScoreService.convertMetresToCentimetres(1.380));
    }
}