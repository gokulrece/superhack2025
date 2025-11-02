package com.kiro.agenticai.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("patches")
public class Patch {
    @Id
    private String id;
    private String name;
    private String impact;
    private String status;
    private String conflict;
    private String summary;
}
