package com.googlecode.t7mp.configuration;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public interface MavenDependency extends Dependency {

    String getGroupId();

    String getArtifactId();

    String getVersion();

    String getExtension();

    String getClassifier();

}
