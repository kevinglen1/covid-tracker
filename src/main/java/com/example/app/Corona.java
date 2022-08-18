package com.example.app;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Corona {

    String combinedKey;

    Long active;

    Long recovered;

    Long confirmed;

    LocalDateTime lastUpdate;
}
