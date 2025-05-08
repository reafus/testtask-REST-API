package timofeev.testtaskrestapi.DTO;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String name,
        int age,
        String email,
        LocalDateTime createdAt
) {
}
