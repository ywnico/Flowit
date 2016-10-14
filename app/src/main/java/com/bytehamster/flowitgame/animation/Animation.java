package com.bytehamster.flowitgame.animation;

import com.bytehamster.flowitgame.object.Drawable;

public abstract class Animation {
    public static final int DURATION_LONG = 400;
    public static final int DURATION_SHORT = 200;
    static final int STEP_DELAY = 30;

    private final Drawable subject;
    private final int startIn;

    Animation(Drawable subject, int startIn) {
        this.subject = subject;
        this.startIn = startIn;
    }

    Drawable getSubject() {
        return subject;
    }

    abstract void start();

    int getStartIn() {
        return startIn;
    }
}
