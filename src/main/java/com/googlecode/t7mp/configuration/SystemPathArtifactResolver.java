package com.googlecode.t7mp.configuration;

import java.io.File;

import org.apache.commons.lang.Validate;

/**
 * FilesystemArtifactResolver can be used in tests to simulate Maven-Artifact resolution.
 * 
 * @author jbellmann
 *
 */
public final class SystemPathArtifactResolver implements PluginArtifactResolver {

    @Override
    public File resolveArtifact(String coordinates) throws ResolutionException {
        Validate.notNull(coordinates);
        File file = new File(coordinates);
        if (file.exists() && file.isFile()) {
            return file;
        }
        throw new ResolutionException("Could not find artifact with coordinates: " + coordinates);
    }

}
