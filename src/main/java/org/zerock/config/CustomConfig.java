package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

// s3 쓰고 지우기 위한 자바빈을 만드는 작업
@Configuration
// root-context에서 참고해서 import
@ImportResource("/WEB-INF/spring/root-context.xml")
public class CustomConfig {

	@Bean
	public S3Client s3Client() {
		return S3Client.builder().region(Region.AP_NORTHEAST_2).build();
	}
}
