package Spring.Boot.Telegram.services.impl;

import Spring.Boot.Telegram.dto.MessageDTO;
import Spring.Boot.Telegram.entities.Chat;
import Spring.Boot.Telegram.entities.Message;
import Spring.Boot.Telegram.entities.User;
import Spring.Boot.Telegram.exceptions.UserNotFoundException;
import Spring.Boot.Telegram.exceptions.ChatNotFoundException;
import Spring.Boot.Telegram.exceptions.MessageNotFoundException;
import Spring.Boot.Telegram.mappers.MessageMapper;
import Spring.Boot.Telegram.repositories.ChatRepository;
import Spring.Boot.Telegram.repositories.MessageRepository;
import Spring.Boot.Telegram.repositories.UserRepository;
import Spring.Boot.Telegram.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserRepository userRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(MessageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageById(Long id) {
        return messageRepository.findById(id)
                .map(MessageMapper::toDTO)
                .orElseThrow(() -> new MessageNotFoundException("Message with ID " + id + " not found"));
    }



    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {
        User user = userRepository.findById(messageDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with ID " + messageDTO.getUserId() + " not found"));

        Chat chat = chatRepository.findById(messageDTO.getChatId())
                .orElseThrow(() -> new ChatNotFoundException("Chat with ID " + messageDTO.getChatId() + " not found"));

        Message message = MessageMapper.toEntity(messageDTO, user, chat);
        message = messageRepository.save(message);
        return MessageMapper.toDTO(message);
    }

    @Override
    public void deleteMessage(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new MessageNotFoundException("Message with ID " + id + " not found");
        }
        messageRepository.deleteById(id);
    }
}
