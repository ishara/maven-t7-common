package com.googlecode.t7mp.configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public class ChainedDependencyResolver implements DependencyResolver {

    protected List<DependencyResolver> chain = new ArrayList<DependencyResolver>();

    protected ChainedDependencyResolver() {
    }

    static DependencyResolver create() {
        ChainedDependencyResolver resolver = new ChainedDependencyResolver();
        resolver.addDependencyResolver(new LocalFileDependencyResolver());
        resolver.addDependencyResolver(new RemoteFileDependencyResolver());
        return resolver;
    }

    @Override
    public File getFile(Dependency dependency) {
        DependencyResolver resolver = getDependencyResolver(dependency);
        if (resolver == null) {
            throw new RuntimeException();
        }
        return resolver.getFile(dependency);
    }

    protected DependencyResolver getDependencyResolver(Dependency dependency) {
        for (DependencyResolver resolver : chain) {
            if (resolver.isDependencySupported(dependency.getClass())) {
                return resolver;
            }
        }
        return null;
    }

    @Override
    public boolean isDependencySupported(Class<? extends Dependency> dependency) {
        for (DependencyResolver resolver : chain) {
            if (resolver.isDependencySupported(dependency)) {
                return true;
            }
        }
        return false;
    }

    public void addDependencyResolver(DependencyResolver resolver) {
        if (resolver == null) {
            throw new RuntimeException();
        }
        this.chain.add(resolver);
    }

}
