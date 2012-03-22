package com.googlecode.t7mp.configuration;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import com.googlecode.t7mp.TomcatArtifact;

public class LocalMavenRepositoryArtifactResolverTest {
	
	@Test
	public void testLocalMavenRepositoryArtifactResolver() throws ResolutionException{
		TomcatArtifact tomcatArtifact = new TomcatArtifact();
		tomcatArtifact.setVersion("7.0.22");
		PluginArtifactResolver resolver = new LocalMavenRepositoryArtifactResolver();
		File file = resolver.resolveArtifact(tomcatArtifact.getArtifactCoordinates());
		Assert.assertNotNull(file);
		Assert.assertTrue(file.isFile());
		Assert.assertFalse(file.isDirectory());
		Assert.assertTrue(file.exists());
		System.out.println(file.getAbsolutePath());
	}
}
