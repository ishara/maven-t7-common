package com.googlecode.t7mp;

import java.io.File;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import com.googlecode.t7mp.configuration.ChainedArtifactResolver;
import com.googlecode.t7mp.configuration.LocalMavenRepositoryArtifactResolver;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public abstract class AbstractBaseTest {

    @Rule
    public static TemporaryFolder tempFolders = new TemporaryFolder();

    protected BaseConfiguration configuration;

    protected ChainedArtifactResolver chainedArtifactResolver;

    @Before
    public void setUp() {
        //
        configuration = new BaseConfiguration();
        TomcatArtifact tomcatArtifact = new TomcatArtifact();
        File catalinaBase = tempFolders.newFolder("catalinaBase");
        configuration.setCatalinaBase(catalinaBase);
        configuration.setTomcatArtifact(tomcatArtifact);
        configuration.setTomcatVersion("7.0.22");
        configuration.setDownloadTomcatExamples(true);
        //
        chainedArtifactResolver = new ChainedArtifactResolver();
        chainedArtifactResolver.addPluginArtifactResolver(new LocalMavenRepositoryArtifactResolver());
    }

}
