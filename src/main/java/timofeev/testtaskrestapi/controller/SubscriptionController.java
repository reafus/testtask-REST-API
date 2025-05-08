package timofeev.testtaskrestapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import timofeev.testtaskrestapi.DTO.SubscriptionResponse;
import timofeev.testtaskrestapi.services.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/top")
    public ResponseEntity<List<SubscriptionResponse>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTop3Popular());
    }
}
