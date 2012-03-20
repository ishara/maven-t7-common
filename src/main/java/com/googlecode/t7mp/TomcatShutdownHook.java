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

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.Bootstrap;

import com.googlecode.t7mp.scanner.Scanner;
import com.googlecode.t7mp.util.CatalinaOutPrintStream;

/**
 * TODO Comment.
 * 
 * @author Joerg Bellmann
 * 
 */
public final class TomcatShutdownHook extends Thread implements ShutdownHook {

    private Bootstrap bootstrap;
    private List<Scanner> scanners = new ArrayList<Scanner>();
    private CatalinaOutPrintStream catalinaOutPrintStream;

    public TomcatShutdownHook(Bootstrap bootstrap, CatalinaOutPrintStream catalinaOutPrintStream) {
        this.bootstrap = bootstrap;
        this.catalinaOutPrintStream = catalinaOutPrintStream;
    }

    public void addScanner(Scanner scanner) {
        this.scanners.add(scanner);
    }

    @Override
    public void run() {
        stopScanners();
        if (bootstrap != null) {
            try {
                bootstrap.stop();
                bootstrap = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (catalinaOutPrintStream != null) {
            catalinaOutPrintStream.flush();
            catalinaOutPrintStream.close();
            System.setErr(catalinaOutPrintStream.getOriginalSystemErr());
        }
    }

    @Override
    public void stopScanners() {
        for (Scanner scanner : scanners) {
            scanner.stop();
        }
    }
}
