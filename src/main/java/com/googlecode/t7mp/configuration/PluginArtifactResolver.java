package com.googlecode.t7mp.configuration;

import java.io.File;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public interface PluginArtifactResolver {

    File resolveArtifact(String coordinates) throws ResolutionException;

}
