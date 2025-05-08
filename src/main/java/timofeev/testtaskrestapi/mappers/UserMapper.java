package timofeev.testtaskrestapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import timofeev.testtaskrestapi.DTO.UserDTO;
import timofeev.testtaskrestapi.DTO.UserResponse;
import timofeev.testtaskrestapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserResponse toUserResponse(User user);

    User toUser(UserDTO dto);

    void updateUserFromDto(UserDTO dto, @MappingTarget User user);
}
