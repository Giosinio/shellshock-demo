package org.security.attacker.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.security.attacker.domain.CommandOutput;
import org.security.attacker.dto.CommandOutputDTO;
import org.security.attacker.repository.CommandOutputRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/command-outputs")
public class CommandOutputController {
    private final CommandOutputRepository commandOutputRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void saveCommandOutput(@RequestBody String output, HttpServletRequest request) {
        String decodedOutput = URLDecoder.decode(output, StandardCharsets.UTF_8);
        String command = request.getHeader("command");
        CommandOutput commandOutput = new CommandOutput(request.getRemoteAddr(), LocalDateTime.now(), command, decodedOutput);
        commandOutputRepository.save(commandOutput);
    }

    @GetMapping
    List<CommandOutputDTO> getCommandOutputs() {
        return commandOutputRepository.findAll().stream()
                .map(CommandOutputDTO::new)
                .toList();
    }

    @GetMapping("/{serverAddress}")
    List<CommandOutputDTO> getCommandOutputsForServer(@PathVariable("serverAddress") String serverAddress) {
        return commandOutputRepository.findByRemoteAddress(serverAddress).stream()
                .map(CommandOutputDTO::new)
                .toList();
    }
}
