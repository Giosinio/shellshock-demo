package org.security.attacker.dto;

import lombok.Data;
import org.security.attacker.domain.VulnerableServer;

import java.time.LocalDateTime;

@Data
public class VulnerableServerDTO {
    private final String remoteAddress;
    private final LocalDateTime lastSuccessfulVulnerabilityCheck;

    public VulnerableServerDTO(VulnerableServer vulnerableServer) {
        this.remoteAddress = vulnerableServer.getRemoteAddress();
        this.lastSuccessfulVulnerabilityCheck = vulnerableServer.getLastSuccessfulVulnerabilityCheck();
    }
}
