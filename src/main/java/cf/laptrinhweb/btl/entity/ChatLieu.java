package cf.laptrinhweb.btl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ChatLieu {
    private Long maChatLieu;
    private String tenChatLieu;
}
