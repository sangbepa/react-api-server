package store.esgseed.api.esgseed.organiztion.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// 1) Organization
@Entity 
@Table(name = "organizations")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class Organization {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sector;
    private String country;          // ISO-2
    private String timezone;        // e.g., "Asia/Seoul"
    private String registrationNumber;

}

