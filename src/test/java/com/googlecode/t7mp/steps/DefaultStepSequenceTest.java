/**
 * Copyright (C) 2010-2012 Joerg Bellmann <joerg.bellmann@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.t7mp.steps;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.googlecode.t7mp.BaseConfiguration;
import com.googlecode.t7mp.configuration.ChainedArtifactResolver;

public class DefaultStepSequenceTest implements StepExecutionListener {

    private AtomicInteger stepsExecuted = new AtomicInteger(0);

    //    private final AbstractT7BaseMojo mojo = Mockito.mock(AbstractT7BaseMojo.class);

    @Before
    public void setUp() {
        stepsExecuted = new AtomicInteger(0);
    }

    @Test
    public void testDefaultStepSequence() {
        StepSequence sequence = new DefaultStepSequence();
        final int rounds = 10;
        for (int i = 0; i < rounds; i++) {
            sequence.add(new ExecutionListenerStep(this));
        }
        Context context = new DefaultContext(new ChainedArtifactResolver(), Mockito.mock(BaseConfiguration.class));
        sequence.execute(context);
        Assert.assertEquals("should be invoked " + rounds + " times", rounds, stepsExecuted.get());
    }

    @Override
    public void stepExecuted(Step source) {
        stepsExecuted.incrementAndGet();
    }

}
