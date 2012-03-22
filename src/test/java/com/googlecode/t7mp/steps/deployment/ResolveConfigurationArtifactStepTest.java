package com.googlecode.t7mp.steps.deployment;

import java.io.File;

import org.junit.Test;

import com.googlecode.t7mp.AbstractBaseTest;
import com.googlecode.t7mp.ConfigurationArtifact;
import com.googlecode.t7mp.TomcatSetupException;
import com.googlecode.t7mp.steps.DefaultContext;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ResolveConfigurationArtifactStepTest extends AbstractBaseTest {

    @Test
    public void testResolveConfigurationArtifactStep() {
        ConfigurationArtifact artifact = new ConfigurationArtifact();
        artifact.setSystemPath(getPath());
        configuration.setConfigArtifact(artifact);
        DefaultContext context = new DefaultContext(chainedArtifactResolver, configuration);
        ResolveConfigurationArtifactStep step = new ResolveConfigurationArtifactStep();
        step.execute(context);
    }

    @Test(expected = TomcatSetupException.class)
    public void testResolveConfigurationArtifactStepWithResolutionException() {
        ConfigurationArtifact artifact = new ConfigurationArtifact();
        artifact.setSystemPath(getPath() + "xxx");
        configuration.setConfigArtifact(artifact);
        DefaultContext context = new DefaultContext(chainedArtifactResolver, configuration);
        ResolveConfigurationArtifactStep step = new ResolveConfigurationArtifactStep();
        step.execute(context);
    }

    private String getPath() {
        File userDir = new File(System.getProperty("user.dir"));
        File resource = new File(userDir, "/src/test/resources/com/googlecode/t7mp/util/tomcatconfig-0.0.1-SNAPSHOT.jar");
        return resource.getAbsolutePath();
    }

}

