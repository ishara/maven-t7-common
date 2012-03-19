package com.googlecode.t7mp.configuration;

/**
 * 
 * @author jbellmann
 *
 */
public interface MavenDependency extends Dependency {

    String getGroupId();

    String getArtifactId();

    String getVersion();

    String getExtension();

    String getClassifier();

}
