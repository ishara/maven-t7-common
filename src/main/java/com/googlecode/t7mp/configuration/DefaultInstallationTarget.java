package com.googlecode.t7mp.configuration;

import java.io.File;

import org.apache.commons.lang.Validate;

/**
 * 
 * @author jbellmann
 *
 */
public final class DefaultInstallationTarget implements TomcatDirectoryLayout {

    private static final String BIN_DIR = "bin";
    private static final String CONF_DIR = "conf";
    private static final String LIB_DIR = "lib";
    private static final String LOGS_DIR = "logs";
    private static final String TEMP_DIR = "temp";
    private static final String WEBAPPS_DIR = "webapps";
    private static final String WORK_DIR = "work";

    private final File installationTargetDirectory;

    public DefaultInstallationTarget(File installationTargetDirectory) {
        Validate.notNull(installationTargetDirectory);
        if (installationTargetDirectory.exists()) {
            Validate.isTrue(installationTargetDirectory.isDirectory(), "InstallationTargetDirectory-parameter should be a directory");
        } else {
            boolean created = installationTargetDirectory.mkdirs();
            if (!created) {
                throw new RuntimeException("Installation target directory could not be created.");
            }
        }
        this.installationTargetDirectory = installationTargetDirectory;
    }

    @Override
    public File getBinDirectory() {
        return createFile(BIN_DIR);
    }

    @Override
    public File getConfDirectory() {
        return createFile(CONF_DIR);
    }

    @Override
    public File getLibDirectory() {
        return createFile(LIB_DIR);
    }

    @Override
    public File getLogsDirectory() {
        return createFile(LOGS_DIR);
    }

    @Override
    public File getTempDirectory() {
        return createFile(TEMP_DIR);
    }

    @Override
    public File getWebappsDirectory() {
        return createFile(WEBAPPS_DIR);
    }

    @Override
    public File getWorkDirectory() {
        return createFile(WORK_DIR);
    }

    protected File createFile(String directory) {
        File directoryFile = new File(this.installationTargetDirectory, directory);
        if (!directoryFile.exists()) {
            boolean created = directoryFile.mkdir();
            if (!created) {
                throw new RuntimeException("Could not create directory " + directoryFile.getAbsolutePath());
            }
        }
        return directoryFile;
    }

}
