package com.googlecode.t7mp.maven;

/**
 * 
 * Takes configurations for t7 Tomcat only (no TomEE).
 *
 * @author Joerg Bellmann
 *
 */
public abstract class AbstractT7TomcatMojo extends AbstractT7BaseMojo {

    /**
     * 
     * @parameter default-value="false"
     */
    protected boolean downloadTomcatExamples = false;

    public boolean isDownloadTomcatExamples() {
        return downloadTomcatExamples;
    }

    public void setDownloadTomcatExamples(boolean downloadTomcatExamples) {
        this.downloadTomcatExamples = downloadTomcatExamples;
    }

}
