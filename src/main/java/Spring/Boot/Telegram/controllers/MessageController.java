package Spring.Boot.Telegram.controllers;

import Spring.Boot.Telegram.dto.MessageDTO;
import Spring.Boot.Telegram.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/get-all-messages")
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messages = messageService.getAllMessages();
        return ResponseEntity.ok(messages);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get-message-by-id/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable Long id) {
        MessageDTO message = messageService.getMessageById(id);

        return message != null ? ResponseEntity.ok(message) : ResponseEntity.notFound().build();
    }



    @PostMapping("/create-message")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO createdMessage = messageService.createMessage(messageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }
    @DeleteMapping("/delete-message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
