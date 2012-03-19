package com.googlecode.t7mp;

/**
 * Use this artifact to resolve the tomcat distribution from Maven-Central.
 * 
 * @author jbellmann
 *
 */
public class TomcatArtifact extends AbstractArtifact {
	
	public static final String DEFAULT_TOMCAT_VERSION = "7.0.26";
    public static final String TOMCAT_GROUPID = "com.googlecode.t7mp";
    public static final String TOMCAT_ARTIFACTID = "tomcat";
    public static final String TOMCAT_TYPE = "zip";
	
	public TomcatArtifact(){
		this(DEFAULT_TOMCAT_VERSION);
	}
	
	public TomcatArtifact(String version){
		super(TOMCAT_GROUPID, TOMCAT_ARTIFACTID, version, null, TOMCAT_TYPE);
	}

	@Override
	public String getType() {
		return "zip";
	}

	@Override
	public String toString() {
		return "TomcatArtifact[" + super.getArtifactCoordinates() + "]";
	}

}
