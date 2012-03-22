package com.googlecode.t7mp.configuration;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ChainedArtifactResolverTest {

    @Test(expected = ResolutionException.class)
    public void testChainedArtifactResolver() throws ResolutionException {
        ChainedArtifactResolver resolver = new ChainedArtifactResolver();
        resolver.addPluginArtifactResolver(new PluginArtifactResolver() {
            @Override
            public File resolveArtifact(String coordinates) throws ResolutionException {
                throw new ResolutionException("TEST");
            }
        });
        resolver.resolveArtifact("a:b:jar:1.0.0");
    }

    @Test
    public void testChainedArtifactResolverJunit() throws ResolutionException {
        ChainedArtifactResolver resolver = new ChainedArtifactResolver();
        resolver.addPluginArtifactResolver(new LocalMavenRepositoryArtifactResolver());
        File file = resolver.resolveArtifact("junit:junit:jar:4.10");
        Assert.assertNotNull(file);
        Assert.assertTrue(file.exists());
    }
}
