package com.googlecode.t7mp.configuration;

import java.io.File;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstallationTargetTest {

    private static Logger LOG = LoggerFactory.getLogger(InstallationTargetTest.class);

    @Rule
    public static TemporaryFolder temporyFolder = new TemporaryFolder();

    @Test
    public void testDefaultInstallationTarget() {
        InstallationTarget target = new DefaultInstallationTarget(temporyFolder.newFolder("tomcat"));
        assertDirectory(target.getBinDirectory());
        assertDirectory(target.getConfDirectory());
        assertDirectory(target.getLibDirectory());
        assertDirectory(target.getLogsDirectory());
        assertDirectory(target.getTempDirectory());
        assertDirectory(target.getWebappsDirectory());
        assertDirectory(target.getWorkDirectory());
    }

    private void assertDirectory(File directory) {
        Assert.assertNotNull(directory);
        Assert.assertTrue(directory.exists());
        Assert.assertTrue(directory.isDirectory());
        LOG.info("Path : " + directory.getAbsolutePath());
    }

    @Test(expected = RuntimeException.class)
    public void testNullArgument() {
        new DefaultInstallationTarget(null);
    }

    @Test
    public void testRootNotExistent() {
        File existentTempDirectory = temporyFolder.newFolder("exist");
        File notExistentDirectory = new File(existentTempDirectory, "notExistentDirectory");
        new DefaultInstallationTarget(notExistentDirectory);
    }

    @Test(expected = RuntimeException.class)
    public void testRootNotExistentAndNotCreateable() {
        File existentTempDirectory = new File("/");
        File notExistentDirectory = new File(existentTempDirectory, "notExistentDirectory/morePath/segments");
        new DefaultInstallationTarget(notExistentDirectory);
    }

    @Test(expected = RuntimeException.class)
    public void testDefaultInstallationTargetWhenMkDirsReturnFalse() {
        DefaultInstallationTarget target = new DefaultInstallationTarget(temporyFolder.newFolder("tomcat"));
        target.createFile("klaus/ralf/egon");
    }

}
