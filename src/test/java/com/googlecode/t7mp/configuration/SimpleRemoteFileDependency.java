package com.googlecode.t7mp.configuration;

import java.net.URL;

class SimpleRemoteFileDependency implements RemoteFileDependency {

    private final URL url;

    SimpleRemoteFileDependency(URL url) {
        this.url = url;
    }

    @Override
    public URL get() {
        return this.url;
    }

}