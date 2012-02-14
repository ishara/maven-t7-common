package com.googlecode.t7mp.steps.deployment;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.googlecode.t7mp.BaseConfiguration;
import com.googlecode.t7mp.PluginLog;
import com.googlecode.t7mp.TomcatSetupException;
import com.googlecode.t7mp.configuration.PluginArtifactResolver;
import com.googlecode.t7mp.configuration.ResolutionException;
import com.googlecode.t7mp.steps.Context;
import com.googlecode.t7mp.steps.Step;
import com.googlecode.t7mp.util.FileFilters;
import com.googlecode.t7mp.util.FileUtil;
import com.googlecode.t7mp.util.ZipUtil;

/**
 * Resolve the configurationArtifact and copy Files to conf-directory.
 * 
 * @author jbellmann
 *
 */
public class ResolveConfigurationArtifactStep implements Step {

    //    protected AbstractT7BaseMojo mojo;
    //    protected MyArtifactResolver myArtifactResolver;
    protected PluginLog logger;

    protected BaseConfiguration baseConfiguration;
    protected PluginArtifactResolver artifactResolver;

    @Override
    public void execute(Context context) {
        //        this.mojo = context.getMojo();
        this.artifactResolver = context.getArtifactResolver();
        this.baseConfiguration = context.getConfiguration();
        this.logger = context.getLog();
        //        this.myArtifactResolver = new MyArtifactResolver(mojo);
        // skip this step if no configuationArtifact is found
        if (context.getMojo().getConfigArtifact() == null) {
            this.logger.info("No configurationArtifact found, skip this step.");
            return;
        }
        // lets do the hard work
        this.logger.debug("resolve configurationArtifact ...");
        File unpackDirectory = null;
        try {
            //          Artifact artifact = resolveTomcatArtifact(version);
            File resolvedArtifact = artifactResolver.resolveArtifact(this.baseConfiguration.getConfigArtifact()
                    .getArtifactCoordinates());
            unpackDirectory = getUnpackDirectory();
            //            ZipUtil.unzip(artifact.getFile(), unpackDirectory);
            ZipUtil.unzip(resolvedArtifact, unpackDirectory);
            this.logger.debug("unzipped to " + unpackDirectory.getAbsolutePath());
            copyToTomcatConfDirectory(unpackDirectory);
        } catch (ResolutionException e) {
            this.logger.error(e.getMessage(), e);
            throw new TomcatSetupException(e.getMessage(), e);
        } catch (IOException e) {
            this.logger.error(e.getMessage(), e);
            throw new TomcatSetupException(e.getMessage(), e);
        } finally {
            if (unpackDirectory != null) {
                try {
                    FileUtils.deleteDirectory(unpackDirectory);
                } catch (IOException e) {
                    this.logger.error("Could not delete temp directory " + unpackDirectory.getAbsolutePath(), e);
                }
            }
        }
    }

    private void copyToTomcatConfDirectory(File unpackDirectory) throws IOException {
        this.logger.debug("copy conf-files ...");
        File confDirectory = new File(this.baseConfiguration.getCatalinaBase(), "conf");
        this.logger.debug("targetConfDirectory is " + confDirectory.getAbsolutePath());
        Set<File> files = FileUtil.getAllFiles(unpackDirectory, FileFilters.forAll(), false);
        for (File file : files) {
            this.logger.debug("copy file " + file.getName() + ", path " + file.getAbsolutePath()
                    + " to targetDirectory");
            FileUtils.copyFileToDirectory(file, confDirectory);
        }
    }

    //    private Artifact resolveConfigurationArtifact() throws MojoExecutionException {
    //        ConfigurationArtifact configured = this.mojo.getConfigArtifact();
    //        Artifact artifact = myArtifactResolver.resolve(configured.getGroupId(), configured.getArtifactId(),
    //                configured.getVersion(), null, configured.getType(), Artifact.SCOPE_COMPILE);
    //        return artifact;
    //    }

    protected File getUnpackDirectory() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File upackDirectory = new File(tempDir, UUID.randomUUID().toString());
        upackDirectory.mkdirs();
        return upackDirectory;
    }
}
