package com.project.codegenerator.entity;

import com.project.codegenerator.enums.MessageRole;

public class ChatMessage {
    Long id;
    ChatSession chatSession;
    MessageRole role;
    String content;
    String toolCalls;
    Integer tokenUsed;
    Integer createdAt;
}
