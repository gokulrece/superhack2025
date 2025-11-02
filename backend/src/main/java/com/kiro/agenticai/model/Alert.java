package com.kiro.agenticai.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("alerts")
public class Alert {
    @Id
    private String id;
    private String title;
    private String severity;
    private String status;
    private String source;
    private LocalDateTime timestamp;
    private String description;
}
