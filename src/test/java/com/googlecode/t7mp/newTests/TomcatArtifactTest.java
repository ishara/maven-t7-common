package com.googlecode.t7mp.newTests;

import junit.framework.Assert;

import org.junit.Test;

import com.googlecode.t7mp.TomcatArtifact;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class TomcatArtifactTest {
	
	@Test
	public void testTomcatArtifact(){
		TomcatArtifact tomcat = new TomcatArtifact();
		Assert.assertEquals(TomcatArtifact.TOMCAT_GROUPID, tomcat.getGroupId());
		Assert.assertEquals(TomcatArtifact.TOMCAT_ARTIFACTID, tomcat.getArtifactId());
		Assert.assertEquals(TomcatArtifact.DEFAULT_TOMCAT_VERSION, tomcat.getVersion());
		Assert.assertEquals("zip", tomcat.getType());
		Assert.assertNull(tomcat.getClassifier());
	}

	@Test
	public void testSpecialVersion(){
		String version = "7.0.30";
		TomcatArtifact tomcat = new TomcatArtifact(version);
		Assert.assertEquals(version, tomcat.getVersion());
	}
	
	@Test
	public void testCoordinates(){
		TomcatArtifact tomcat = new TomcatArtifact();
		Assert.assertEquals("com.googlecode.t7mp:tomcat:zip:7.0.26", tomcat.getArtifactCoordinates());
	}
	
	@Test
	public void testCoordinatesWithSystemPath(){
		TomcatArtifact tomcat = new TomcatArtifact();
		tomcat.setSystemPath("/home/Joerg Bellmann/test/tomcat.zip");
		Assert.assertEquals("/home/Joerg Bellmann/test/tomcat.zip", tomcat.getArtifactCoordinates());
	}
	
}
