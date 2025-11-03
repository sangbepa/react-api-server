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
    private final Double scope1Tco2e;
    private final Double scope2Tco2e;
    private final Double totalScope12Tco2e;
    private final Double scope3Tco2e;

}