package com.googlecode.t7mp.configuration;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.googlecode.t7mp.AbstractArtifact;

public class LocalMavenRepositoryArtifactResolver implements
		PluginArtifactResolver {
	
	private final File localMavenRepository;
	
	public LocalMavenRepositoryArtifactResolver(){
		localMavenRepository = createLocalMavenRepository();
	}
	
	public LocalMavenRepositoryArtifactResolver(String localMavenRepositoryPath){
		Validate.notEmpty(localMavenRepositoryPath);
		localMavenRepository = createLocalMavenRepository(new File(localMavenRepositoryPath));
	}

	private File createLocalMavenRepository() {
		File userHomeDirectory = new File(System.getProperty("user.home"));
		File repositoryDirectory = new File(userHomeDirectory, "/.m2/repository");
		return createLocalMavenRepository(repositoryDirectory);
	}
	
	private File createLocalMavenRepository(File file){
		Validate.isTrue(file.isDirectory(), "The directory " + file.getAbsolutePath() + " does not exist.");
		return file;
	}

	@Override
	public File resolveArtifact(String coordinates) throws ResolutionException {
		Validate.notEmpty(coordinates);
		AbstractArtifact artifact = Artifacts.fromCoordinates(coordinates);
		String relativePath = createRelativeArtifactPath(artifact);
		File result = new File(this.localMavenRepository, relativePath);
		if(!result.isFile()){
			throw new ResolutionException("Resolved file is a directory.");
		}else if (!result.exists()){
			throw new ResolutionException("File " + result.getAbsolutePath() + " does not exist.");
		}
		return result;
	}
	
	protected String createRelativeArtifactPath(AbstractArtifact artifact){
		StringBuilder sb = new StringBuilder();
		sb.append(artifact.getGroupId().replace('.', '/')).append("/");
		sb.append(artifact.getArtifactId()).append("/");
		sb.append(artifact.getVersion()).append("/");
		sb.append(artifact.getArtifactId()).append("-").append(artifact.getVersion());
		if(!StringUtils.isBlank(artifact.getClassifier())){
			sb.append("-").append(artifact.getClassifier());
		}
		sb.append(".").append(artifact.getType());
		return sb.toString();
	}

}
