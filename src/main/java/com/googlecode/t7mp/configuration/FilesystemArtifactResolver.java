package com.googlecode.t7mp.configuration;

import java.io.File;

import com.googlecode.t7mp.Assert;

/**
 * FilesystemArtifactResolver can be used in tests to simulate Maven-Artifact resolution.
 * 
 * @author jbellmann
 *
 */
public final class FilesystemArtifactResolver implements ArtifactResolver {

    @Override
    public File resolveArtifact(String coordinates) throws ResolutionException {
        Assert.notNull(coordinates);
        File file = new File(coordinates);
        if (file.exists() && file.isFile()) {
            return file;
        }
        throw new ResolutionException("Could not find file " + coordinates);
    }

}
