package timofeev.testtaskrestapi.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timofeev.testtaskrestapi.DTO.UserDTO;
import timofeev.testtaskrestapi.DTO.UserResponse;
import timofeev.testtaskrestapi.mappers.UserMapper;
import timofeev.testtaskrestapi.model.User;
import timofeev.testtaskrestapi.repository.UserRepository;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUserAndMap(UserDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        User user = userMapper.toUser(dto);
        user = userRepository.save(user);
        log.info("Creating user: {}", dto.email());
        return userMapper.toUserResponse(user);
    }

    public UserResponse getUserResponseById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id.toString()));
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUserAndMap(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (!user.getEmail().equals(dto.email()) && userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("New email already exists");
        }
        userMapper.updateUserFromDto(dto, user);
        user = userRepository.save(user);
        log.info("Updating user: {}", id);
        return userMapper.toUserResponse(user);
    }

    public void deleteUser(Long id) {
        log.info("Deleting user: {}", id);
        userRepository.deleteById(id);
    }

}
