package timofeev.testtaskrestapi.DTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record SubscriptionDTO(
        @NotBlank String serviceName,
        LocalDateTime endDate
) {
}
