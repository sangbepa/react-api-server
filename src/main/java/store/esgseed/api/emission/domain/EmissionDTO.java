package store.esgseed.api.emission.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmissionDTO {


        private String site;
        private Double scope1Tco2e;
        private Double scope2Tco2e;
        private Double totalScope12Tco2e;
        private Double scope3Tco2e;
    

    
}
