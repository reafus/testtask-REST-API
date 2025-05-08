package timofeev.testtaskrestapi.DTO;

import java.time.LocalDateTime;

public record SubscriptionResponse(
        Long id,
        String serviceName,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
