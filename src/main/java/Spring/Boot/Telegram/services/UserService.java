package Spring.Boot.Telegram.services;

import Spring.Boot.Telegram.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    void deleteUser(Long id);
}
