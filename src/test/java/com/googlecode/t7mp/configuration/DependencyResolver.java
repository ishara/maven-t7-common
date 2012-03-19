package com.googlecode.t7mp.configuration;

import java.io.File;

public interface DependencyResolver {

    File getFile(Dependency dependency);

    boolean isDependencySupported(Class<? extends Dependency> dependencyClass);

}
