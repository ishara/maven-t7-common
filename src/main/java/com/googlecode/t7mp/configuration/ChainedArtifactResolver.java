package com.googlecode.t7mp.configuration;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ChainedArtifactResolver implements PluginArtifactResolver {

    protected List<PluginArtifactResolver> resolverChain = new LinkedList<PluginArtifactResolver>();

    public ChainedArtifactResolver() {
        this.resolverChain.add(new SystemPathArtifactResolver());
    }

    @Override
    public File resolveArtifact(final String coordinates) throws ResolutionException {
        File result = null;
        for (PluginArtifactResolver resolver : resolverChain) {
            try {
                result = resolver.resolveArtifact(coordinates);
            } catch (ResolutionException e) {
                // 
            }
        }
        if (result == null) {
            throw new ResolutionException("Could not resolve artifact with coordinates " + coordinates);
        }
        return result;
    }

    public void addPluginArtifactResolver(PluginArtifactResolver pluginArtifactResolver) {
        Validate.notNull(pluginArtifactResolver, "PluginArtifactResolvers should not be null");
        this.resolverChain.add(pluginArtifactResolver);
    }

}
