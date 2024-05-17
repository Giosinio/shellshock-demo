package org.security.attacker.repository;

import org.security.attacker.domain.CommandOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandOutputRepository extends JpaRepository<CommandOutput, Long> {
    List<CommandOutput> findByRemoteAddress(String remoteAddress);
}
