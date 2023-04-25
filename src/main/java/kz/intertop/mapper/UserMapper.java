package kz.intertop.mapper;

import kz.intertop.dto.UserDto;
import kz.intertop.models.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
