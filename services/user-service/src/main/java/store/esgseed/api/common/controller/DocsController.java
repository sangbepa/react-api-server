package store.esgseed.api.common.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * API 문서 접근을 위한 컨트롤러
 */
@Controller
@Hidden // Swagger UI에서 이 컨트롤러는 숨김
public class DocsController {

    /**
     * 루트 경로 접근 시 Swagger UI로 리다이렉트
     */
    @GetMapping("/")
    public RedirectView redirectToSwagger() {
        return new RedirectView("/swagger-ui/index.html");
    }

    /**
     * /docs 경로 접근 시 Swagger UI로 리다이렉트
     */
    @GetMapping("/docs")
    public RedirectView docsRedirect() {
        return new RedirectView("/swagger-ui/index.html");
    }

    /**
     * /api-docs 경로 접근 시 OpenAPI JSON으로 리다이렉트
     */
    @GetMapping("/api-docs")
    public RedirectView apiDocsRedirect() {
        return new RedirectView("/v3/api-docs");
    }
}

