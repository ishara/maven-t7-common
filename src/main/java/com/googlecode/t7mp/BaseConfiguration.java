package com.googlecode.t7mp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.googlecode.t7mp.scanner.ScannerConfiguration;

/**
 * 
 * @author jbellmann
 *
 */
public class BaseConfiguration {

    public static final int DEFAULT_TOMCAT_HTTP_PORT = 8080;

    public static final int DEFAULT_TOMCAT_SHUTDOWN_PORT = 8005;

    public static final String DEFAULT_CONTEXT_PATH_ROOT = "ROOT";
    
    protected TomcatArtifact tomcatArtifact = new TomcatArtifact();

    /**
     * 
     * @parameter expression="${t7.tomcatSetAwait}" default-value="true"
     * 
     */
    protected boolean tomcatSetAwait = true;

    /**
     * 
     * @parameter expression="${t7.lookInside}" default-value="false"
     * 
     */
    protected boolean lookInside = false;

    /**
     * 
     * @parameter expression="${t7.resolverUpdateSnapshotsAlways}" default-value="false"
     */
    protected boolean resolverUpdateSnapshotsAllways = false;

    /**
     * 
     * @parameter expression="${t7.tomcatVersion}" default-value="7.0.22"
     */
    protected String tomcatVersion = TomcatArtifact.DEFAULT_TOMCAT_VERSION;

    /**
     * 
     * @parameter expression="${t7.tomcatHttpPort}" default-value="8080"
     */
    protected int tomcatHttpPort = DEFAULT_TOMCAT_HTTP_PORT;

    /**
     * 
     * @parameter expression="${t7.tomcatShutdownPort}" default-value="8005"
     */
    protected int tomcatShutdownPort = DEFAULT_TOMCAT_SHUTDOWN_PORT;

    /**
     * 
     * @parameter expression="${t7.tomcatShutdownCommand}" default-value="SHUTDOWN"
     */
    protected String tomcatShutdownCommand = "SHUTDOWN";

    /**
     * 
     * @parameter expression="${t7.tomcatShutdownHost}" default-value="localhost"
     * 
     */
    protected String tomcatShutdownHost = "localhost";

    /**
     * 
     * @parameter default-value="${project.build.directory}/tomcat"
     * @readonly // at the moment
     * 
     */
    protected File catalinaBase;

    /**
     * 
     * @parameter expression="${t7.tomcatConfigDirectory}" default-value="${basedir}/src/main/tomcat/conf"
     * @optional
     * 
     */
    protected File tomcatConfigDirectory;

    /**
     * 
     * @parameter expression="${t7.overwriteWebXML}"
     */
    protected File overwriteWebXML;

    /**
     * 
     * @parameter default-value="${project.build.directory}/${project.build.finalName}"
     * @readonly
     * 
     */
    protected File webappOutputDirectory;

    /**
     *
     * @parameter expression="${t7.contextPath}" default-value="${project.build.finalName}"
     * @optional
     *
     */
    protected String contextPath = DEFAULT_CONTEXT_PATH_ROOT;

    /**
     * @parameter default-value="${project.build.finalName}"
     * @readonly
     */
    protected String buildFinalName = DEFAULT_CONTEXT_PATH_ROOT;

    /**
     * @parameter default-value="${basedir}/src/main/webapp"
     * @readonly
     */
    protected File webappSourceDirectory = null;

    /**
     * @parameter default-value="${project.packaging}"
     * 
     * 
     */
    protected String packaging = "war";

    /**
     * 
     * @parameter expression="${t7.scanClasses}" default-value="false"
     */
    protected boolean scanClasses = false;

    /**
     * @parameter default-value="${basedir}/target/classes"
     * @readonly
     */
    protected File webappClassDirectory = null;

    /**
     * @parameter
     * @optional
     */
    protected File contextFile = null;

    /**
     * 
     * @parameter
     */
    protected ArrayList<AbstractArtifact> webapps = new ArrayList<AbstractArtifact>();

    /**
     * 
     * @parameter
     */
    protected Map<String, String> systemProperties = new HashMap<String, String>();

    /**
     * 
     * @parameter
     */
    protected List<AbstractArtifact> libs = new ArrayList<AbstractArtifact>();

    /**
     * 
     * @parameter
     */
    protected ArrayList<ScannerConfiguration> scanners = new ArrayList<ScannerConfiguration>();

    /**
     * 
     * @parameter default-value="false"
     */
    protected boolean suspendConsoleOutput = false;

    /**
     * @parameter
     */
    protected ConfigurationArtifact configArtifact = null;

    /**
     * 
     * @parameter default-value="false"
     */
    protected boolean downloadTomcatExamples = false;

    public boolean isTomcatSetAwait() {
        return tomcatSetAwait;
    }

    public void setTomcatSetAwait(boolean tomcatSetAwait) {
        this.tomcatSetAwait = tomcatSetAwait;
    }

    public boolean isLookInside() {
        return lookInside;
    }

    public void setLookInside(boolean lookInside) {
        this.lookInside = lookInside;
    }

    public boolean isResolverUpdateSnapshotsAllways() {
        return resolverUpdateSnapshotsAllways;
    }

    public void setResolverUpdateSnapshotsAllways(boolean resolverUpdateSnapshotsAllways) {
        this.resolverUpdateSnapshotsAllways = resolverUpdateSnapshotsAllways;
    }

    public String getTomcatVersion() {
        return tomcatVersion;
    }

    public void setTomcatVersion(String tomcatVersion) {
        this.tomcatVersion = tomcatVersion;
    }

    public int getTomcatHttpPort() {
        return tomcatHttpPort;
    }

    public void setTomcatHttpPort(int tomcatHttpPort) {
        this.tomcatHttpPort = tomcatHttpPort;
    }

    public int getTomcatShutdownPort() {
        return tomcatShutdownPort;
    }

    public void setTomcatShutdownPort(int tomcatShutdownPort) {
        this.tomcatShutdownPort = tomcatShutdownPort;
    }

    public String getTomcatShutdownCommand() {
        return tomcatShutdownCommand;
    }

    public void setTomcatShutdownCommand(String tomcatShutdownCommand) {
        this.tomcatShutdownCommand = tomcatShutdownCommand;
    }

    public String getTomcatShutdownHost() {
        return tomcatShutdownHost;
    }

    public void setTomcatShutdownHost(String tomcatShutdownHost) {
        this.tomcatShutdownHost = tomcatShutdownHost;
    }

    public File getCatalinaBase() {
        return catalinaBase;
    }

    public void setCatalinaBase(File catalinaBase) {
        this.catalinaBase = catalinaBase;
    }

    public File getTomcatConfigDirectory() {
        return tomcatConfigDirectory;
    }

    public void setTomcatConfigDirectory(File tomcatConfigDirectory) {
        this.tomcatConfigDirectory = tomcatConfigDirectory;
    }

    public File getOverwriteWebXML() {
        return overwriteWebXML;
    }

    public void setOverwriteWebXML(File overwriteWebXML) {
        this.overwriteWebXML = overwriteWebXML;
    }

    public File getWebappOutputDirectory() {
        return webappOutputDirectory;
    }

    public void setWebappOutputDirectory(File webappOutputDirectory) {
        this.webappOutputDirectory = webappOutputDirectory;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getBuildFinalName() {
        return buildFinalName;
    }

    public void setBuildFinalName(String buildFinalName) {
        this.buildFinalName = buildFinalName;
    }

    public File getWebappSourceDirectory() {
        return webappSourceDirectory;
    }

    public void setWebappSourceDirectory(File webappSourceDirectory) {
        this.webappSourceDirectory = webappSourceDirectory;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public boolean isScanClasses() {
        return scanClasses;
    }

    public void setScanClasses(boolean scanClasses) {
        this.scanClasses = scanClasses;
    }

    public File getWebappClassDirectory() {
        return webappClassDirectory;
    }

    public void setWebappClassDirectory(File webappClassDirectory) {
        this.webappClassDirectory = webappClassDirectory;
    }

    public File getContextFile() {
        return contextFile;
    }

    public void setContextFile(File contextFile) {
        this.contextFile = contextFile;
    }

    public ArrayList<AbstractArtifact> getWebapps() {
        return webapps;
    }

    public void setWebapps(ArrayList<AbstractArtifact> webapps) {
        this.webapps = webapps;
    }

    public Map<String, String> getSystemProperties() {
        return systemProperties;
    }

    public void setSystemProperties(Map<String, String> systemProperties) {
        this.systemProperties = systemProperties;
    }

    public List<AbstractArtifact> getLibs() {
        return libs;
    }

    public void setLibs(List<AbstractArtifact> libs) {
        this.libs = libs;
    }

    public ArrayList<ScannerConfiguration> getScanners() {
        return scanners;
    }

    public void setScanners(ArrayList<ScannerConfiguration> scanners) {
        this.scanners = scanners;
    }

    public boolean isSuspendConsoleOutput() {
        return suspendConsoleOutput;
    }

    public void setSuspendConsoleOutput(boolean suspendConsoleOutput) {
        this.suspendConsoleOutput = suspendConsoleOutput;
    }

    public ConfigurationArtifact getConfigArtifact() {
        return configArtifact;
    }

    public void setConfigArtifact(ConfigurationArtifact configArtifact) {
        this.configArtifact = configArtifact;
    }

    public boolean isWebProject() {
        return this.packaging.equals("war");
    }

    public boolean isDownloadTomcatExamples() {
        return downloadTomcatExamples;
    }

    public void setDownloadTomcatExamples(boolean downloadTomcatExamples) {
        this.downloadTomcatExamples = downloadTomcatExamples;
    }
    
    public TomcatArtifact getTomcatArtifact(){
    	return this.tomcatArtifact;
    }
    
    public void setTomcatArtifact(TomcatArtifact tomcatArtifact){
    	this.tomcatArtifact = tomcatArtifact;
    }
}
