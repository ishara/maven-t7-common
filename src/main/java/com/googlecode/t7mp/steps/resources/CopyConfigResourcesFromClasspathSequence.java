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

import com.googlecode.t7mp.steps.DefaultStepSequence;

public class CopyConfigResourcesFromClasspathSequence extends DefaultStepSequence {

    public CopyConfigResourcesFromClasspathSequence() {
        this.add(new CopyConfigResourceFromClasspath("context.xml"));
        this.add(new CopyConfigResourceFromClasspath("catalina.policy"));
        this.add(new CopyConfigResourceFromClasspath("logging.properties"));
        this.add(new CopyConfigResourceFromClasspath("server.xml"));
        this.add(new CopyConfigResourceFromClasspath("tomcat-users.xml"));
        this.add(new CopyConfigResourceFromClasspath("web.xml"));
    }

}
