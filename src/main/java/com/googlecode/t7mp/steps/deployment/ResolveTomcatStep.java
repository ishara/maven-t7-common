/**
 * Copyright (C) 2010-2011 Joerg Bellmann <joerg.bellmann@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.t7mp.steps.deployment;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.googlecode.t7mp.AbstractT7TomcatMojo;
import com.googlecode.t7mp.PluginLog;
import com.googlecode.t7mp.TomcatSetupException;
import com.googlecode.t7mp.maven.MyArtifactResolver;
import com.googlecode.t7mp.steps.Context;
import com.googlecode.t7mp.steps.Step;
import com.googlecode.t7mp.util.ZipUtil;

/**
 * TODO Comment.
 * 
 * @author jbellmann
 *
 */
public class ResolveTomcatStep implements Step {

    public static final String TOMCAT_GROUPID = "com.googlecode.t7mp";
    public static final String TOMCAT_ARTIFACTID = "tomcat";
    public static final String TOMCAT_TYPE = "zip";

    protected AbstractT7TomcatMojo mojo;
    protected MyArtifactResolver myArtifactResolver;
    protected PluginLog logger;

    //    protected

    @Override
    public void execute(Context context) {
        this.mojo = (AbstractT7TomcatMojo) context.getMojo();
        this.myArtifactResolver = new MyArtifactResolver(context.getMojo());
        this.logger = context.getLog();
        String version = null;
        String configuredVersion = context.getMojo().getTomcatVersion();
        if (mojo.isDownloadTomcatExamples()) {
            logger.info("Resolve Tomcat with 'docs' and 'examples'");
            version = configuredVersion;
        } else {
            logger.info("Resolve Tomcat without 'docs' and 'examples'.");
            version = configuredVersion + ".A";
        }
        if (StringUtils.isEmpty(version)) {
            throw new TomcatSetupException("Version should not be null or empty.");
        }

        File unpackDirectory = null;
        try {
            Artifact artifact = resolveTomcatArtifact(version);
            unpackDirectory = getUnpackDirectory();
            ZipUtil.unzip(artifact.getFile(), unpackDirectory);
            copyToTomcatDirectory(unpackDirectory);
        } catch (MojoExecutionException e) {
            logger.error(e.getMessage(), e);
            throw new TomcatSetupException(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new TomcatSetupException(e.getMessage(), e);
        } finally {
            if (unpackDirectory != null) {
                try {
                    FileUtils.deleteDirectory(unpackDirectory);
                } catch (IOException e) {
                    logger.error("Could not delete tomcat upack directory : " + unpackDirectory.getAbsolutePath());
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    private void copyToTomcatDirectory(File unpackDirectory) throws IOException {
        File[] files = unpackDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        // should only be one
        FileUtils.copyDirectory(files[0], this.mojo.getCatalinaBase());
    }

    protected Artifact resolveTomcatArtifact(String tomcatVersion) throws MojoExecutionException {
        Artifact artifact = myArtifactResolver.resolve(TOMCAT_GROUPID, TOMCAT_ARTIFACTID, tomcatVersion, null,
                TOMCAT_TYPE, Artifact.SCOPE_COMPILE);
        return artifact;
    }

    protected File getUnpackDirectory() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File upackDirectory = new File(tempDir, UUID.randomUUID().toString());
        upackDirectory.mkdirs();
        return upackDirectory;
    }

}
