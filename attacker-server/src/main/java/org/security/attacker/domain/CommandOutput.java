package org.security.attacker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class CommandOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String remoteAddress;
    private LocalDateTime accessingTime;
    private String command;
    private String result;

    public CommandOutput(String remoteAddress, LocalDateTime accessingTime, String command, String result) {
        this.remoteAddress = remoteAddress;
        this.accessingTime = accessingTime;
        this.command = command;
        this.result = result;
    }
}
