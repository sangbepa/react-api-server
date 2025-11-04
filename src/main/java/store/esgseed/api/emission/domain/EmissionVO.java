package store.esgseed.api.emission.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 배출량 Value Object - 불변 객체
 */
@Getter
@AllArgsConstructor
public class EmissionVO {

    private final String site;
    private final String scope1Tco2e;
    private final String scope2Tco2e;
    private final String totalScope12Tco2e;
    private final String scope3Tco2e;

}