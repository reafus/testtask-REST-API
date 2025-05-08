package timofeev.testtaskrestapi.mappers;

import org.mapstruct.Mapper;
import timofeev.testtaskrestapi.DTO.SubscriptionDTO;
import timofeev.testtaskrestapi.DTO.SubscriptionResponse;
import timofeev.testtaskrestapi.model.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    Subscription toSubscription(SubscriptionDTO subscriptionDTO);
}
