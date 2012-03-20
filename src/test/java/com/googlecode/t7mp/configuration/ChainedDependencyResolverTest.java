package com.googlecode.t7mp.configuration;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ChainedDependencyResolverTest {

    @Test
    public void testEmptyChainedResolver() {
        DependencyResolver resolver = new ChainedDependencyResolver();
        Assert.assertFalse(resolver.isDependencySupported(MavenDependency.class));
        Assert.assertFalse(resolver.isDependencySupported(LocalFileDependency.class));
        Assert.assertFalse(resolver.isDependencySupported(RemoteFileDependency.class));
    }

    @Test
    public void testWithLocalFileDependencyResolver() {
        ChainedDependencyResolver resolver = new ChainedDependencyResolver();
        resolver.addDependencyResolver(new LocalFileDependencyResolver());
        Assert.assertTrue(resolver.isDependencySupported(LocalFileDependency.class));
        Assert.assertFalse(resolver.isDependencySupported(RemoteFileDependency.class));
    }

    @Test
    public void testWithRemoteFileDependencyResolver() {
        ChainedDependencyResolver resolver = new ChainedDependencyResolver();
        resolver.addDependencyResolver(new RemoteFileDependencyResolver());
        Assert.assertFalse(resolver.isDependencySupported(LocalFileDependency.class));
        Assert.assertTrue(resolver.isDependencySupported(RemoteFileDependency.class));
        File result = resolver.getFile(Dependencies.create("https://Joerg Bellmann.de/index.html"));
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getAbsolutePath().endsWith(".html"));
    }

    @Test
    public void testStaticCreation() {
        DependencyResolver resolver = ChainedDependencyResolver.create();
        Assert.assertTrue(resolver.isDependencySupported(LocalFileDependency.class));
        Assert.assertTrue(resolver.isDependencySupported(RemoteFileDependency.class));
        File result = resolver.getFile(Dependencies.create("https://Joerg Bellmann.de/index.html"));
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getAbsolutePath().endsWith(".html"));

    }

}
