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
package com.googlecode.t7mp.newTests;

import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.googlecode.t7mp.BaseConfiguration;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class BaseConfigurationTest {
	
	@Rule
	public static TemporaryFolder folders = new TemporaryFolder();
	
	private File catalinaBaseDirectory = null;
	
	@Before
	public void setUp(){
		catalinaBaseDirectory = folders.newFolder("catalinaBase");
	}
	
	@Test
	public void testBaseconfiguration(){
		BaseConfiguration configuration = new BaseConfiguration();
		configuration.setCatalinaBase(catalinaBaseDirectory);
		Assert.assertEquals(8080, configuration.getTomcatHttpPort());
		Assert.assertEquals(8005, configuration.getTomcatShutdownPort());
		Assert.assertEquals(BaseConfiguration.DEFAULT_CONTEXT_PATH_ROOT, configuration.getBuildFinalName());
		Assert.assertNotNull(configuration.getCatalinaBase());
		Assert.assertEquals("7.0.26", configuration.getTomcatVersion());
	}

}
