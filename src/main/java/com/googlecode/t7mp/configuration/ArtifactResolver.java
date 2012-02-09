package com.googlecode.t7mp.configuration;

import java.io.File;

/**
 * 
 * @author jbellmann
 *
 */
public interface ArtifactResolver {

    File resolveArtifact(String coordinates) throws ResolutionException;

}
