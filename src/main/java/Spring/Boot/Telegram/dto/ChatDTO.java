package Spring.Boot.Telegram.dto;

import java.util.List;

public class ChatDTO {
    private Long id;
    private String name;
    private String text;
    private List<Long> userIds;
    private List<Long> messageIds;

    public List<Long> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Long> messageIds) {
        this.messageIds = messageIds;
    }

    public List<Long> getChatIds() {
        return chatIds;
    }

    public void setChatIds(List<Long> chatIds) {
        this.chatIds = chatIds;
    }

    private List<Long> chatIds;

    public ChatDTO() {
    }

    public ChatDTO(Long id, String name, String text, List<Long> userIds, List<Long> messageIds) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.userIds = userIds;
        this.messageIds = messageIds;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
