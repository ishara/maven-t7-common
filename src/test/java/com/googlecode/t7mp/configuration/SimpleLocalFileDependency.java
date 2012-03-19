package com.googlecode.t7mp.configuration;

import java.io.File;
import java.net.URI;

class SimpleLocalFileDependency implements LocalFileDependency {

    private final URI uri;

    SimpleLocalFileDependency(URI uri) {
        this.uri = uri;
    }

    @Override
    public File get() {
        return new File(this.uri);
    }

}