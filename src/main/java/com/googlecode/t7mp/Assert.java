package com.googlecode.t7mp;

/**
 * 
 * @author jbellmann
 *
 */
public final class Assert {

    private Assert() {
        //hide constructor
    }

    public static void notNull(Object object) {
        notNull(object, "should not be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new RuntimeException(message);
        }
    }

    public static void isTrue(boolean state) {
        isTrue(state, "Should be true");
    }

    public static void isTrue(boolean state, String message) {
        if (!state) {
            throw new RuntimeException(message);
        }
    }
}
