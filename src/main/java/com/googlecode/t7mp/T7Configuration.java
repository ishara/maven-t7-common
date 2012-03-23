package com.googlecode.t7mp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.googlecode.t7mp.scanner.ScannerConfiguration;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public interface T7Configuration {

    boolean isTomcatSetAwait();

    boolean isLookInside();

    boolean isResolverUpdateSnapshotsAllways();

    String getTomcatVersion();

    int getTomcatHttpPort();

    int getTomcatShutdownPort();

    String getTomcatShutdownCommand();

    String getTomcatShutdownHost();

    File getCatalinaBase();

    File getTomcatConfigDirectory();

    File getOverwriteWebXML();

    File getWebappOutputDirectory();

    String getContextPath();

    String getBuildFinalName();

    File getWebappSourceDirectory();

    String getPackaging();

    boolean isScanClasses();

    File getWebappClassDirectory();

    File getContextFile();

    ArrayList<AbstractArtifact> getWebapps();

    Map<String, String> getSystemProperties();

    List<AbstractArtifact> getLibs();

    ArrayList<ScannerConfiguration> getScanners();

    boolean isSuspendConsoleOutput();

    ConfigurationArtifact getConfigArtifact();

    boolean isWebProject();

    boolean isDownloadTomcatExamples();

    TomcatArtifact getTomcatArtifact();

}
