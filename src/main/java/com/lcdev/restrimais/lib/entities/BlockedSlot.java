package com.lcdev.restrimais.lib.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_blocked_slot")
public class BlockedSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nutritionist_id", nullable = false)
    private Nutritionist nutritionist;

    private LocalDateTime blockedStart;
    private LocalDateTime blockedEnd;
}
