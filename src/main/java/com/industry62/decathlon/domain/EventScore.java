package com.industry62.decathlon.domain;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;

@Data
public class EventScore {

    private Event event;

    @PositiveOrZero(message = "Event score should not be negative")
    private double score;
}
