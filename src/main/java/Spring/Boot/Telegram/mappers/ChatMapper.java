package Spring.Boot.Telegram.mappers;

import Spring.Boot.Telegram.dto.ChatDTO;
import Spring.Boot.Telegram.entities.Chat;
import Spring.Boot.Telegram.entities.User;
import Spring.Boot.Telegram.entities.Message;

import java.util.stream.Collectors;

public class ChatMapper {

    public static ChatDTO toDTO(Chat chat) {
        if (chat == null) {
            return null;
        }
        ChatDTO dto = new ChatDTO();
        dto.setId(chat.getId());
        dto.setName(chat.getName());
        dto.setText(chat.getText());
        dto.setUserIds(chat.getUsers().stream().map(User::getId).collect(Collectors.toList()));
        dto.setMessageIds(chat.getMessages().stream().map(Message::getId).collect(Collectors.toList()));
        return dto;
    }

    public static Chat toEntity(ChatDTO dto) {
        if (dto == null) {
            return null;
        }
        Chat chat = new Chat();
        chat.setId(dto.getId());
        chat.setName(dto.getName());
        chat.setText(dto.getText());
        return chat;
    }
}
