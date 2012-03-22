package com.googlecode.t7mp.newTests;

import org.junit.Test;

import com.googlecode.t7mp.AbstractBaseTest;
import com.googlecode.t7mp.steps.DefaultContext;
import com.googlecode.t7mp.steps.StepSequence;
import com.googlecode.t7mp.steps.deployment.TomcatSetupSequence;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class TomcatSetupSequenceTest extends AbstractBaseTest {

    @Test
    public void testTomcatSetupSequence() {
        DefaultContext context = new DefaultContext(chainedArtifactResolver, configuration);
        StepSequence sequence = new TomcatSetupSequence();
        sequence.execute(context);
        System.out.println(configuration.getCatalinaBase().getAbsolutePath());
    }
}
