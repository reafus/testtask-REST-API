package timofeev.testtaskrestapi.services;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import timofeev.testtaskrestapi.DTO.SubscriptionDTO;
import timofeev.testtaskrestapi.DTO.SubscriptionResponse;
import timofeev.testtaskrestapi.mappers.SubscriptionMapper;
import timofeev.testtaskrestapi.model.Subscription;
import timofeev.testtaskrestapi.model.User;
import timofeev.testtaskrestapi.repository.SubscriptionRepository;
import timofeev.testtaskrestapi.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionService.class);
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserRepository userRepository, SubscriptionMapper subscriptionMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.subscriptionMapper = subscriptionMapper;
    }

    public SubscriptionResponse addSubscription(Long userId, SubscriptionDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Subscription subscription = subscriptionMapper.toSubscription(dto);
        subscription.setUser(user);
        subscription.setStartDate(LocalDateTime.now());
        subscription = subscriptionRepository.save(subscription);
        log.info("Adding subscription {} to user {}", dto.serviceName(), userId);
        return subscriptionMapper.toSubscriptionResponse(subscription);
    }

    public List<SubscriptionResponse> getTop3Popular() {
        return subscriptionRepository.findTop3PopularServices().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<SubscriptionResponse> getUserSubscriptions(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return subscriptionRepository.findByUserId(userId).stream()
                .map(subscriptionMapper::toSubscriptionResponse)
                .toList();
    }

    public void deleteSubscription(Long userId, Long subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));

        if (!subscription.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("Subscription does not belong to user");
        }

        log.info("Deleting subscription {} from user {}", subscriptionId, userId);
        subscriptionRepository.delete(subscription);
    }

    private SubscriptionResponse convertToResponse(Object[] result) {
        return new SubscriptionResponse(
                null,
                (String) result[0],
                null,
                null
        );
    }
}
