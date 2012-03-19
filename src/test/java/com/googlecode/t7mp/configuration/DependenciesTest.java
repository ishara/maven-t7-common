package com.googlecode.t7mp.configuration;

import org.junit.Assert;
import org.junit.Test;

public class DependenciesTest {
    @Test
    public void testCoordinatesUtil() throws Exception {
        Dependency result = Dependencies.create("junit:junit:4.10");
        Assert.assertNotNull(result);
        Assert.assertTrue(MavenDependency.class.isAssignableFrom(result.getClass()));
        Dependency result2 = Dependencies.create("junit:junit:jar:4.10");
        Assert.assertNotNull(result2);
        Assert.assertTrue(MavenDependency.class.isAssignableFrom(result2.getClass()));
        Dependency result3 = Dependencies.create("junit:junit:jar:test:4.10");
        Assert.assertNotNull(result3);
        Assert.assertTrue(MavenDependency.class.isAssignableFrom(result3.getClass()));
    }

    @Test(expected = Exception.class)
    public void testMavenCoordinatesToShort() throws Exception {
        Dependencies.create("junit:junit");
    }

    @Test(expected = Exception.class)
    public void testMavenCoordinatesToLong() throws Exception {
        Dependencies.create("junit:junit:jar:test:bla:bla:4.10");
    }

    @Test
    public void testLocalFileDependency() throws Exception {
        Dependency result = Dependencies.create("file:///users/klaus/peter");
        Assert.assertNotNull(result);
        Assert.assertTrue(LocalFileDependency.class.isAssignableFrom(result.getClass()));
    }

    @Test
    public void testRemoteFileDependency() throws Exception {
        Dependency result = Dependencies.create("https://www.fakeserver.test/index.html");
        Assert.assertNotNull(result);
        Assert.assertTrue(RemoteFileDependency.class.isAssignableFrom(result.getClass()));
        Dependency result2 = Dependencies.create("http://www.fakeserver.test/index.html");
        Assert.assertNotNull(result2);
        Assert.assertTrue(RemoteFileDependency.class.isAssignableFrom(result2.getClass()));
    }
}
