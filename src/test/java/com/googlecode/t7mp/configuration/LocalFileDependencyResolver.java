package com.googlecode.t7mp.configuration;

import java.io.File;

class LocalFileDependencyResolver implements DependencyResolver {

    LocalFileDependencyResolver() {
    }

    @Override
    public File getFile(Dependency dependency) {
        return ((LocalFileDependency) dependency).get();
    }

    @Override
    public boolean isDependencySupported(Class<? extends Dependency> dependencyClass) {
        return LocalFileDependency.class.isAssignableFrom(dependencyClass);
    }

}