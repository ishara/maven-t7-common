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
package com.googlecode.t7mp.maven;

import org.apache.catalina.startup.Bootstrap;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Bootstrap.class })
public class StopMojoTest {

    //    private Bootstrap bootstrap;
    //    private Map<Object, Object> pluginContext;
    //
    //    @Before
    //    public void setUp() {
    //        bootstrap = PowerMockito.mock(Bootstrap.class);
    //        pluginContext = new HashMap<Object, Object>();
    //        pluginContext.put(AbstractT7BaseMojo.T7_BOOTSTRAP_CONTEXT_ID, bootstrap);
    //    }
    //
    //    @Test
    //    public void testExecute() throws Exception {
    //        StopMojo mojo = new StopMojo();
    //        mojo.setPluginContext(pluginContext);
    //        mojo.execute();
    //        Mockito.verify(bootstrap, Mockito.atLeastOnce()).stop();
    //    }
    //
    //    @Test
    //    public void testExecuteWithEmptyPluginContext() throws Exception {
    //        StopMojo mojo = new StopMojo();
    //        pluginContext.put(AbstractT7BaseMojo.T7_BOOTSTRAP_CONTEXT_ID, null);
    //        mojo.setPluginContext(pluginContext);
    //        mojo.execute();
    //        Assert.assertTrue(pluginContext.get(AbstractT7BaseMojo.T7_BOOTSTRAP_CONTEXT_ID) == null);
    //    }
    //
    //    @Test(expected = MojoExecutionException.class)
    //    public void testExecuteWithException() throws Exception {
    //        Mockito.doThrow(new Exception("TESTEXCEPTION")).when(bootstrap).stop();
    //        StopMojo mojo = new StopMojo();
    //        mojo.setPluginContext(pluginContext);
    //        mojo.execute();
    //        Mockito.verify(bootstrap, Mockito.atLeastOnce()).stop();
    //    }

}
