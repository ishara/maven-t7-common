package com.googlecode.t7mp;

import org.junit.Test;

public class T7LogAdapterTest {

    @Test
    public void testT7LogAdapter() {
        PluginLog log = new DefaultPluginLog();
        log.debug("A Debug-Message");
        log.info("A Info-Message");
        log.warn("A Warn-Message");
        log.error("A Error-Message");
        log.error("A Error-Message with Throwable", new RuntimeException("Just for the test."));

        PluginLog inside = new LookInsideLog(log);
        inside.debug("A INSIDE-Debug-Message");
        inside.info("A INSIDE-Info-Message");
        inside.warn("A-INSIDE-Warn-Message");
        inside.error("A INSIDE-Error-Message");
    }

}
