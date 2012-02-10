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
package com.googlecode.t7mp.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * 
 * @goal run
 * @requiresDependencyResolution test
 * 
 * 
 */
@Deprecated
public class RunMojo extends AbstractT7TomcatMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }

    //    protected Bootstrap bootstrap;
    //
    //    private final PluginLog log = new DefaultPluginLog();
    //
    //    @Override
    //    @SuppressWarnings("unchecked")
    //    public void execute() throws MojoExecutionException, MojoFailureException {
    //        PreConditions.checkConfiguredTomcatVersion(log, tomcatVersion);
    //
    //        getSetupStepSequence().execute(new DefaultContext(this));
    //
    //        PrintStream originalSystemErr = System.err;
    //
    //        bootstrap = getBootstrap();
    //        getLog().info("Starting Tomcat ...");
    //        try {
    //            File catalinaout = new File(this.getCatalinaBase(), "/logs/catalina.out");
    //            CatalinaOutPrintStream catalinaOutputStream = new CatalinaOutPrintStream(originalSystemErr,
    //                    new FileOutputStream(catalinaout), isSuspendConsoleOutput());
    //            System.setErr(catalinaOutputStream);
    //            bootstrap.init();
    //            final TomcatShutdownHook shutdownHook = new TomcatShutdownHook(bootstrap, catalinaOutputStream);
    //            ScannerSetup.configureScanners(shutdownHook, getBaseConfiguration(), log);
    //            if (tomcatSetAwait) {
    //                Runtime.getRuntime().addShutdownHook(shutdownHook);
    //                bootstrap.setAwait(tomcatSetAwait);
    //                bootstrap.start();
    //            } else {
    //                bootstrap.start();
    //                getPluginContext().put(T7_BOOTSTRAP_CONTEXT_ID, bootstrap);
    //                Runtime.getRuntime().addShutdownHook(shutdownHook);
    //                getLog().info("Tomcat started");
    //            }
    //        } catch (Exception e) {
    //            throw new MojoExecutionException(e.getMessage(), e);
    //        }
    //    }
    //
    //    private BaseConfiguration getBaseConfiguration() {
    //        return null;
    //    }
    //
    //    protected StepSequence getSetupStepSequence() {
    //        StepSequence seq = new TomcatSetupSequence();
    //        seq.add(new CopyJuliJarStep());
    //        return seq;
    //    }
    //
    //    protected Bootstrap getBootstrap() {
    //        return new Bootstrap();
    //    }

}
