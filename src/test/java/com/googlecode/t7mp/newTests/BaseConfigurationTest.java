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
 * @author jbellmann
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
