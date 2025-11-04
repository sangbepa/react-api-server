package store.esgseed.api.player.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

/**
 * 선수 DTO - API 요청/응답 데이터
 */
@Schema(description = "선수 데이터 모델")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    @Schema(description = "선수 ID", example = "1")
    private Long playerId;

    @Schema(description = "선수명", example = "손흥민")
    private String playerName;

    @Schema(description = "영문 선수명", example = "Son Heung-Min")
    private String ePlayerName;

    @Schema(description = "닉네임", example = "소니")
    private String nickname;

    @Schema(description = "입단년도", example = "2010")
    private Integer joinYyyy;

    @Schema(description = "포지션", example = "FW")
    private String position;

    @Schema(description = "등번호", example = "7")
    private Integer backNo;

    @Schema(description = "국적", example = "대한민국")
    private String nation;

    @Schema(description = "생년월일", example = "1992-07-08")
    private LocalDate birthDate;

    @Schema(description = "양/음력", example = "양")
    private String solar;

    @Schema(description = "키 (cm)", example = "183.0")
    private Double height;

    @Schema(description = "몸무게 (kg)", example = "77.0")
    private Double weight;
}

