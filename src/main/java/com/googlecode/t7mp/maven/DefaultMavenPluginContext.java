package com.googlecode.t7mp.maven;

import com.googlecode.t7mp.BaseConfiguration;
import com.googlecode.t7mp.PluginLog;
import com.googlecode.t7mp.configuration.PluginArtifactResolver;
import com.googlecode.t7mp.steps.Context;

public class DefaultMavenPluginContext implements MavenPluginContext {
    
    protected Context context;
    protected AbstractT7BaseMojo mojo;
    
    public DefaultMavenPluginContext(Context parent, AbstractT7BaseMojo mojo){
        
    }

    @Override
    public PluginLog getLog() {
        return context.getLog();
    }

    @Override
    public PluginArtifactResolver getArtifactResolver() {
        return context.getArtifactResolver();
    }

    @Override
    public BaseConfiguration getConfiguration() {
        return context.getConfiguration();
    }

    @Override
    public void put(String key, Object value) {
        context.put(key, value);

    }

    @Override
    public Object get(String key) {
        return context.get(key);
    }

    @Override
    public void clear() {
        context.clear();
    }

    @Override
    public AbstractT7BaseMojo getMojo() {
        return this.mojo;
    }

}
