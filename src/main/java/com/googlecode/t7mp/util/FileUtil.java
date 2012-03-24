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
package com.googlecode.t7mp.util;

import java.io.File;
import java.io.FileFilter;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Little Helper.
 * 
 * @author Joerg Bellmann
 *
 */
public final class FileUtil {

    private FileUtil() {
        //hide constructor
    }

    public static Set<File> getAllFiles(File rootDirectory) {
        Set<File> fileSet = Sets.newHashSet();
        return getAllFiles(rootDirectory, fileSet);
    }

    public static Set<File> getAllFiles(File rootDirectory, FileFilter fileFilter, boolean includeSubdirectories) {
        Set<File> fileSet = Sets.newHashSet();
        return getAllFiles(rootDirectory, fileSet, fileFilter, includeSubdirectories);
    }

    private static Set<File> getAllFiles(File rootDirectory, Set<File> fileSet) {
        File[] files = rootDirectory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getAllFiles(file, fileSet);
            } else {
                fileSet.add(file);
            }
        }
        return fileSet;
    }

    private static Set<File> getAllFiles(File rootDirectory, Set<File> fileSet, FileFilter fileFilter,
            boolean includeSubdirectories) {
        File[] files = rootDirectory.listFiles();
        for (File file : files) {
            if (file.isDirectory() && includeSubdirectories) {
                getAllFiles(file, fileSet, fileFilter, includeSubdirectories);
            } else {
                if (fileFilter.accept(file)) {
                    fileSet.add(file);
                }
            }
        }
        return fileSet;
    }

}
