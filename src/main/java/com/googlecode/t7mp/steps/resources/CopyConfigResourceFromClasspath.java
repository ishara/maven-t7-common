/**
 * Copyright (C) 2010-2012 Joerg Bellmann <joerg.bellmann@googlemail.com>
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
package com.googlecode.t7mp.steps.resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.googlecode.t7mp.SetupUtil;
import com.googlecode.t7mp.TomcatSetupException;
import com.googlecode.t7mp.steps.Context;
import com.googlecode.t7mp.steps.Step;
import com.googlecode.t7mp.util.CommonsSetupUtil;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class CopyConfigResourceFromClasspath implements Step {

    private static final String MSG_PREFIX = "Could not copy classpathresource ";
    private static final String MSG_SUFFIX = " to tomcat-conf directory";

    private static final String RESOURCEPATH = "/com/googlecode/t7mp/conf/";

    private SetupUtil setupUtil = new CommonsSetupUtil();

    private final String resource;

    public CopyConfigResourceFromClasspath(String resource) {
        this.resource = resource;
    }

    @Override
    public void execute(Context context) {
        final File tomcatConfDirectory = new File(context.getConfiguration().getCatalinaBase(), "/conf/");
        try {
            FileOutputStream out = new FileOutputStream(new File(tomcatConfDirectory, resource));
            this.setupUtil.copy(getClass().getResourceAsStream(RESOURCEPATH + resource), out);
            out.close();
        } catch (FileNotFoundException e) {
            throw new TomcatSetupException(MSG_PREFIX + resource + MSG_SUFFIX, e);
        } catch (IOException e) {
            throw new TomcatSetupException(MSG_PREFIX + resource + MSG_SUFFIX, e);
        }
    }
}
