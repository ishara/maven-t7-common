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
	
	public static AbstractArtifact fromCoordinates(String coordinates){
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
