package org.security.attacker.repository;

import org.security.attacker.domain.VulnerableServer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VulnerableServerRepository extends JpaRepository<VulnerableServer, Long> {

}
