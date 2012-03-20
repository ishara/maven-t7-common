package com.googlecode.t7mp.configuration;

import java.io.File;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public interface TomcatDirectoryLayout {

    File getBinDirectory();

    File getConfDirectory();

    File getLibDirectory();

    File getLogsDirectory();

    File getTempDirectory();

    File getWebappsDirectory();

    File getWorkDirectory();

}
