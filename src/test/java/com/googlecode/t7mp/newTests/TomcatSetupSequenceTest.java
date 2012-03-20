package com.googlecode.t7mp.newTests;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.googlecode.t7mp.BaseConfiguration;
import com.googlecode.t7mp.TomcatArtifact;
import com.googlecode.t7mp.configuration.ChainedArtifactResolver;
import com.googlecode.t7mp.steps.DefaultContext;
import com.googlecode.t7mp.steps.StepSequence;
import com.googlecode.t7mp.steps.deployment.TomcatSetupSequence;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class TomcatSetupSequenceTest {
    
    private final String systemPathToAnTomcatZip = "/home/jbellmann/Downloads/apache-tomcat-7.0.26.zip";

    @Rule
    public static TemporaryFolder tempFolders = new TemporaryFolder();
    
    @Test
    public void testTomcatSetupSequence(){
        BaseConfiguration configuration = new BaseConfiguration();
        TomcatArtifact tomcatArtifact = new TomcatArtifact();
        tomcatArtifact.setSystemPath(systemPathToAnTomcatZip);
        File catalinaBase = tempFolders.newFolder("catalinaBase");
        configuration.setCatalinaBase(catalinaBase);
        configuration.setTomcatArtifact(tomcatArtifact);
        DefaultContext context = new DefaultContext(new ChainedArtifactResolver(), configuration);
        StepSequence sequence = new TomcatSetupSequence();
        sequence.execute(context);
        System.out.println(catalinaBase.getAbsolutePath());
    }
    
}
