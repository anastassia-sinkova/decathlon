package com.industry62.decathlon.domain;

public enum Event {
    METRES_100(25.4347, 18, 1.81),
    LONG_JUMP(0.14354, 220, 1.4),
    SHOT_PUT(51.39, 1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42),
    METRES_400(1.53775, 82, 1.81),
    METRES_110_HURDLES(5.74352, 28.5, 1.92),
    DISCUS_THROW(12.91, 4, 1.1),
    POLE_VAULT(0.2797, 100, 1.35),
    JAVELIN_THROW(10.14, 7, 1.08),
    METRES_1500(0.03768, 480, 1.85);

    public final double A;
    public final double B;
    public final double C;

    Event(double a, double b, double c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }
}
