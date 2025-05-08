package timofeev.testtaskrestapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import timofeev.testtaskrestapi.DTO.SubscriptionDTO;
import timofeev.testtaskrestapi.DTO.SubscriptionResponse;
import timofeev.testtaskrestapi.DTO.UserDTO;
import timofeev.testtaskrestapi.DTO.UserResponse;
import timofeev.testtaskrestapi.services.SubscriptionService;
import timofeev.testtaskrestapi.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final SubscriptionService subscriptionService;


    public UserController(UserService userService, SubscriptionService subscriptionService) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserDTO dto) {
        return ResponseEntity.ok(userService.createUserAndMap(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserResponseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody @Valid UserDTO dto) {
        return ResponseEntity.ok(userService.updateUserAndMap(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/subscriptions")
    public ResponseEntity<SubscriptionResponse> addSubscription(
            @PathVariable Long userId,
            @RequestBody @Valid SubscriptionDTO dto) {
        return ResponseEntity.ok(subscriptionService.addSubscription(userId, dto));
    }

    @GetMapping("/{userId}/subscriptions")
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions(
            @PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{userId}/subscriptions/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(
            @PathVariable Long userId,
            @PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
