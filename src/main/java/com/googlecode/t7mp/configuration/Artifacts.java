package com.googlecode.t7mp.configuration;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.googlecode.t7mp.AbstractArtifact;

/**
 * 
 * @author Joerg Bellmann
 *
 */
public final class Artifacts {
    
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    private Artifacts() {
        // hide constructor
    }

    public static AbstractArtifact fromCoordinates(String coordinates) {
        Iterable<String> splitted = Splitter.on(':').omitEmptyStrings().trimResults().split(coordinates);
        String[] strings = Iterables.toArray(splitted, String.class);
        if (strings.length < THREE || strings.length > FIVE) {
            throw new InvalidCoordinatesException(coordinates);
        } else {
            String extension = "jar"; //DEFAULT
            String classifier = null; //DEFAULT
            String groupId = strings[ZERO];
            String artifactId = strings[ONE];
            String version = strings[strings.length - ONE];
            if (strings.length == FOUR) {
                extension = strings[TWO];
            }
            if (strings.length == FIVE) {
                classifier = strings[THREE];
            }
            return new DefaultArtifact(groupId, artifactId, version, classifier, extension);
        }
    }

    static final class DefaultArtifact extends AbstractArtifact {

        private String type;

        DefaultArtifact(String groupId, String artifactId, String version, String classifier, String type) {
            super(groupId, artifactId, version, classifier, type);
            this.type = type;
        }

        @Override
        public String getType() {
            return type;
        }
    }

}
