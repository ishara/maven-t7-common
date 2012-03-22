package com.googlecode.t7mp.newTests;

import org.junit.Test;

import com.googlecode.t7mp.AbstractBaseTest;
import com.googlecode.t7mp.steps.DefaultContext;
import com.googlecode.t7mp.steps.deployment.ResolveTomcatStep;

/**
 * 
 * @author Joerg Bellmann
 *
 */
//@Ignore
public class ResolveTomcatStepTest extends AbstractBaseTest {

    @Test
    public void testResolveTomcatStep() {
        DefaultContext context = new DefaultContext(chainedArtifactResolver, this.configuration);
        ResolveTomcatStep step = new ResolveTomcatStep();
        step.execute(context);
        System.out.println(configuration.getCatalinaBase().getAbsolutePath());
    }

}
