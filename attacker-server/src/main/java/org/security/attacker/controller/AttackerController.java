package org.security.attacker.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.security.attacker.domain.VulnerableServer;
import org.security.attacker.dto.VulnerableServerDTO;
import org.security.attacker.repository.VulnerableServerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/attacker")
@RequiredArgsConstructor
public class AttackerController {
    private final VulnerableServerRepository vulnerableServerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void saveVulnerableServerData(HttpServletRequest request) {
        String remoteAddress = request.getRemoteAddr();
        vulnerableServerRepository.save(new VulnerableServer(remoteAddress, LocalDateTime.now()));
    }

    @GetMapping("/vulnerable-servers")
    List<VulnerableServerDTO> getVulnerableServerList() {
        return vulnerableServerRepository.findAll().stream().map(VulnerableServerDTO::new).toList();
    }


}
