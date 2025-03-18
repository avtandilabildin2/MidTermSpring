package Spring.Boot.Telegram.services;

import Spring.Boot.Telegram.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<MessageDTO> getAllMessages();
    MessageDTO getMessageById(Long id);
    MessageDTO createMessage(MessageDTO messageDTO);
    void deleteMessage(Long id);
}
