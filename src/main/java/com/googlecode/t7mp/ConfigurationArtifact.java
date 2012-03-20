package com.googlecode.t7mp;

/**
 * An ConfigurationArtifact.
 * 
 * @author Joerg Bellmann
 *
 */
public class ConfigurationArtifact extends JarArtifact {

    @Override
    public String toString() {
        return "ConfigurationArtifact[" + getArtifactCoordinates() + "]";
    }

}
