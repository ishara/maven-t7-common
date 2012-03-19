package com.googlecode.t7mp.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;

class RemoteFileDependencyResolver implements DependencyResolver {

    RemoteFileDependencyResolver() {
    }

    @Override
    public File getFile(Dependency dependency) {
        URL url = ((RemoteFileDependency) dependency).get();
        int idx = url.toString().lastIndexOf(".");
        String suffix = url.toString().substring(idx - 1);
        //download resource to a File and return it;
        File file = null;
        try {
            file = File.createTempFile("remote_resolved_", suffix);
        } catch (IOException e) {
            throw new RuntimeException(url + " could not be resolved");
        }
        return file;
    }

    @Override
    public boolean isDependencySupported(Class<? extends Dependency> dependencyClass) {
        return RemoteFileDependency.class.isAssignableFrom(dependencyClass);
    }

}