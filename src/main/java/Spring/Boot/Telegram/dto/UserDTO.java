package Spring.Boot.Telegram.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private List<Long> chatIds;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(Long id, String username, List<Long> chatIds) {
        this.id = id;
        this.username = username;
        this.chatIds = chatIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getChatIds() {
        return chatIds;
    }

    public void setChatIds(List<Long> chatIds) {
        this.chatIds = chatIds;
    }
}
