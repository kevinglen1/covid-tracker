package com.example.app;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Corona {

    @Id
    @Column(name="id", updatable = false, unique = true)
            @GeneratedValue(strategy = GenerationType.IDENTIFY)
    Long id;

    String combinedKey;

    Long confirmed;

    LocalDateTime lastUpdate;
}
