package com.googlecode.t7mp.configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public final class Dependencies {

    public static Dependency create(String coordinates) {
        if (coordinates.startsWith("file://")) {
            try {
                return new SimpleLocalFileDependency(new URI(coordinates));
            } catch (URISyntaxException e) {
                throw new InvalidCoordinatesException(coordinates);
            }
        }
        if (coordinates.startsWith("http://") || coordinates.startsWith("https://")) {
            try {
                return new SimpleRemoteFileDependency(new URL(coordinates));
            } catch (MalformedURLException e) {
                throw new InvalidCoordinatesException(coordinates);
            }
        }
        // only maven is further supported
        Iterable<String> splitted = Splitter.on(':').omitEmptyStrings().trimResults().split(coordinates);
        String[] strings = Iterables.toArray(splitted, String.class);
        if (strings.length < 3 || strings.length > 5) {
            throw new InvalidCoordinatesException(coordinates);
        } else {
            String extension = "jar"; //DEFAULT
            String classifier = null; //DEFAULT
            String groupId = strings[0];
            String artifactId = strings[1];
            String version = strings[strings.length - 1];
            if (strings.length == 4) {
                extension = strings[2];
            }
            if (strings.length == 5) {
                classifier = strings[3];
            }
            return new SimpleMavenDependency(groupId, artifactId, version, extension, classifier);
        }
    }

}
