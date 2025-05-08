package timofeev.testtaskrestapi.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank String name,
        @Min(0) int age,
        @NotBlank @Email String email
) {
}
