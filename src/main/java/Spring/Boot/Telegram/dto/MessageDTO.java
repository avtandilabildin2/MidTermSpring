package Spring.Boot.Telegram.dto;

public class MessageDTO {
    private Long id;
    private String content;
    private Long userId;
    private Long chatId;

    public MessageDTO(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Constructor
    public MessageDTO(Long id, String content, Long userId, Long chatId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.chatId = chatId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
