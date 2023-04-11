package kz.RealIntertop.mapper;

import kz.RealIntertop.dto.UserDto;
import kz.RealIntertop.models.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);
}
