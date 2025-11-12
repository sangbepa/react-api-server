package store.esgseed.api.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS 전역 설정
 * 프론트엔드(localhost:3000)에서 백엔드(localhost:8080)로의 요청 허용
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/api/**")  // /api/** 경로에 대해
                .allowedOrigins("http://localhost:3000")  // localhost:3000 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")  // 허용할 HTTP 메서드
                .allowedHeaders("*")  // 모든 헤더 허용
                .allowCredentials(true)  // 쿠키/인증 정보 허용
                .maxAge(3600);  // preflight 요청 캐시 시간 (1시간)
        
        System.out.println("✅ CORS 설정 완료: localhost:3000 허용");
    }
}

