package com.skylife_Transformation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SkylifeTransformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkylifeTransformationApplication.class, args);
		log.trace("trace {}", "트레이스!");
		log.debug("debug {}", "디버거");
		log.info("info {}", "기본");
		log.warn("warn {}", "경고");
		log.error("error {}", "에러");
	}

}
