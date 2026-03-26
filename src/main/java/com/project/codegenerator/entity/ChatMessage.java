package com.project.codegenerator.entity;

import com.project.codegenerator.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    MessageRole role;
    String content;
    String toolCalls;
    Integer tokenUsed;
    Integer createdAt;
}
