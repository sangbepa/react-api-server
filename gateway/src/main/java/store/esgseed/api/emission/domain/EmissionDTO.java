package store.esgseed.api.emission.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 배출량 DTO - API 요청/응답 데이터
 */
@Schema(description = "배출량 데이터 모델")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmissionDTO {

        @Schema(description = "사업장명", example = "삼성전자 수원사업장", required = true)
        private String site;

        @Schema(description = "Scope 1 배출량 (tCO2e)", example = "1234.567", required = true)
        private String scope1Tco2e;

        @Schema(description = "Scope 2 배출량 (tCO2e)", example = "2345.678", required = true)
        private String scope2Tco2e;

        @Schema(description = "Scope 1+2 총 배출량 (tCO2e)", example = "3580.245", required = true)
        private String totalScope12Tco2e;

        @Schema(description = "Scope 3 배출량 (tCO2e)", example = "4567.890")
        private String scope3Tco2e;

}
