package Spring.Boot.Telegram.mappers;

import Spring.Boot.Telegram.dto.UserDTO;
import Spring.Boot.Telegram.entities.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        List<Long> chatIds = user.getChats() != null ?
                user.getChats().stream().map(chat -> chat.getId()).collect(Collectors.toList()) : null;

        return new UserDTO(user.getId(), user.getUsername(), chatIds);
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
