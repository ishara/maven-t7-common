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
package com.googlecode.t7mp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.catalina.startup.Bootstrap;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.googlecode.t7mp.scanner.ScannerSetup;
import com.googlecode.t7mp.steps.DefaultContext;
import com.googlecode.t7mp.steps.StepSequence;
import com.googlecode.t7mp.steps.deployment.CopyJuliJarStep;
import com.googlecode.t7mp.steps.deployment.TomcatSetupSequence;
import com.googlecode.t7mp.util.CatalinaOutPrintStream;

/**
 * 
 * @goal run
 * @requiresDependencyResolution test
 * 
 * 
 */
@Deprecated
public class RunMojo extends AbstractT7TomcatMojo {

    protected Bootstrap bootstrap;

    @Override
    @SuppressWarnings("unchecked")
    public void execute() throws MojoExecutionException, MojoFailureException {
        PreConditions.checkConfiguredTomcatVersion(getLog(), tomcatVersion);

        getSetupStepSequence().execute(new DefaultContext(this));

        PrintStream originalSystemErr = System.err;

        bootstrap = getBootstrap();
        getLog().info("Starting Tomcat ...");
        try {
            File catalinaout = new File(this.getCatalinaBase(), "/logs/catalina.out");
            CatalinaOutPrintStream catalinaOutputStream = new CatalinaOutPrintStream(originalSystemErr,
                    new FileOutputStream(catalinaout), isSuspendConsoleOutput());
            System.setErr(catalinaOutputStream);
            bootstrap.init();
            final TomcatShutdownHook shutdownHook = new TomcatShutdownHook(bootstrap, catalinaOutputStream);
            ScannerSetup.configureScanners(shutdownHook, this);
            if (tomcatSetAwait) {
                Runtime.getRuntime().addShutdownHook(shutdownHook);
                bootstrap.setAwait(tomcatSetAwait);
                bootstrap.start();
            } else {
                bootstrap.start();
                getPluginContext().put(T7_BOOTSTRAP_CONTEXT_ID, bootstrap);
                Runtime.getRuntime().addShutdownHook(shutdownHook);
                getLog().info("Tomcat started");
            }
        } catch (Exception e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    protected StepSequence getSetupStepSequence() {
        StepSequence seq = new TomcatSetupSequence();
        seq.add(new CopyJuliJarStep());
        return seq;
    }

    protected Bootstrap getBootstrap() {
        return new Bootstrap();
    }

}
