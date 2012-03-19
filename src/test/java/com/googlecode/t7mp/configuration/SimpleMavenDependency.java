package com.googlecode.t7mp.configuration;

import com.googlecode.t7mp.AbstractArtifact;

class SimpleMavenDependency extends AbstractArtifact implements MavenDependency {

    private final String extension;

    SimpleMavenDependency(String groupId, String artifactId, String version, String extension, String classifier) {
        super(groupId, artifactId, version, classifier, extension);
        this.extension = extension;
    }

    @Override
    public String getExtension() {
        return this.extension;
    }

    @Override
    public String getType() {
        return this.extension;
    }

}