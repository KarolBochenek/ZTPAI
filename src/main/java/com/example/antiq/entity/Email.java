package com.example.antiq.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Email {
    private String to;
    private String subject;
    private Map<String, Object> dynamicValue;
    private String templateName;
}
