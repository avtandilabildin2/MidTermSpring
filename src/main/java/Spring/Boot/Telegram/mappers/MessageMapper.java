package Spring.Boot.Telegram.mappers;

import Spring.Boot.Telegram.dto.MessageDTO;
import Spring.Boot.Telegram.entities.Message;
import Spring.Boot.Telegram.entities.User;
import Spring.Boot.Telegram.entities.Chat;

public class MessageMapper {

    public static MessageDTO toDTO(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getContent(),
                message.getUser().getId(),
                message.getChat().getId()
        );
    }

    public static Message toEntity(MessageDTO messageDTO, User user, Chat chat) {
        Message message = new Message();
        message.setId(messageDTO.getId());
        message.setContent(messageDTO.getContent());
        message.setUser(user);
        message.setChat(chat);
        return message;
    }
}
