package com.industry62.decathlon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventScore {

    @NotNull(message = "Event name missing")
    private Event event;

    @NotNull(message = "Event score missing")
    @PositiveOrZero(message = "Event score should not be negative")
    private Double score;
}
