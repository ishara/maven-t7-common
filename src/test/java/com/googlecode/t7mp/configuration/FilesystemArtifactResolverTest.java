package com.googlecode.t7mp.configuration;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * FilesystemArtifactResolverTest.
 * 
 * @author jbellmann
 *
 */
public class FilesystemArtifactResolverTest {

    @Test
    public void testFilesystemArtifactResolver() throws ResolutionException {
        String path = getClass().getResource("/TEST.txt").getPath();
        //
        FilesystemArtifactResolver resolver = new FilesystemArtifactResolver();
        File testFile = resolver.resolveArtifact(path);
        Assert.assertNotNull(testFile);
        Assert.assertTrue(testFile.exists());
        Assert.assertTrue(testFile.isFile());
        Assert.assertFalse(testFile.isDirectory());
    }

}
