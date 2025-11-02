package com.kiro.agenticai.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private String priority;
    private String status;
    private String relatedTo;
    private String summary;
}
