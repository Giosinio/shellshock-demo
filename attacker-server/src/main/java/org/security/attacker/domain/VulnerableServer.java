package org.security.attacker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class VulnerableServer {
    @Id
    @NonNull
    private String remoteAddress;

    private LocalDateTime lastSuccessfulVulnerabilityCheck;

    public VulnerableServer(@NonNull String remoteAddress, LocalDateTime lastSuccessfulVulnerabilityCheck) {
        this.remoteAddress = remoteAddress;
        this.lastSuccessfulVulnerabilityCheck = lastSuccessfulVulnerabilityCheck;
    }
}