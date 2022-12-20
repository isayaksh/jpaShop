package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableJpaAuditing
public class JpashopApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpashopApplication.class, args);
	}

	/**
	 * 회원 목록 캐시 정보를 초기화
	 **/
	@Scheduled(fixedDelay = 10000) // 10s에 한번씩 실행
	@CacheEvict(value = "members", allEntries = true) // 캐시 제거
	public void cacheInitialization(){}

}
