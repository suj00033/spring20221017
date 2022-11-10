package org.zerock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

// s3 쓰고 지우기 위한 자바빈을 만드는 작업
@Configuration
// root-context에서 참고해서 import
@ImportResource("/WEB-INF/spring/root-context.xml")
public class CustomConfig {

	// field로 만들어서 사용
	@Value("${aws.accessKeyId}")
	private String accessKeyId;
	
	@Value("${aws.secretAccessKey}")
	private String secretAccessKey;

	@Bean
	public S3Client s3Client() {
		return S3Client.builder()
				.credentialsProvider(awsCredentialsProvider())
				.region(Region.AP_NORTHEAST_2).build();
	}
	
	@Bean
	public AwsCredentialsProvider awsCredentialsProvider() {
		return StaticCredentialsProvider.create(awsCredentials());
	}
	
	@Bean
	public AwsCredentials awsCredentials() {
		return AwsBasicCredentials.create(accessKeyId, secretAccessKey);
	}
}
