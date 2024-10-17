package sistema.entregas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRecordDto(@NotNull(message = "O campo não pode ser nulo")
                                @NotBlank(message = "O campo não pode estar em branco")
                                String name,
                                @NotNull(message = "O campo não pode ser nulo")
                                @NotBlank(message = "O campo não pode estar em branco")
                                String cpf) {
}
