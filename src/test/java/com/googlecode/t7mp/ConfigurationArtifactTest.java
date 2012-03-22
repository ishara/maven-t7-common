package com.googlecode.t7mp;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ConfigurationArtifactTest {

    @Test
    public void testConfigurationArtifact() {
        ConfigurationArtifact configurationArtifact = new ConfigurationArtifact();
        configurationArtifact.setGroupId("bla");
        configurationArtifact.setArtifactId("blub");
        configurationArtifact.setVersion("1.0.0");
        Assert.assertEquals("1.0.0", configurationArtifact.getVersion());
        Assert.assertEquals("blub", configurationArtifact.getArtifactId());
        Assert.assertEquals("bla", configurationArtifact.getGroupId());
        Assert.assertEquals("jar", configurationArtifact.getType());
        Assert.assertEquals("ConfigurationArtifact[bla:blub:jar:1.0.0]", configurationArtifact.toString());
    }

}
