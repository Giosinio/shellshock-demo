package org.security.attacker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.security.attacker.domain.CommandOutput;

import java.time.LocalDateTime;

@Data
public class CommandOutputDTO {
    private LocalDateTime accessingTime;
    private String command;
    private Object result;

    public CommandOutputDTO(CommandOutput commandOutput) {
        this.accessingTime = commandOutput.getAccessingTime();
        this.command = commandOutput.getCommand();
        this.result = commandOutput.getResult();
    }
}
