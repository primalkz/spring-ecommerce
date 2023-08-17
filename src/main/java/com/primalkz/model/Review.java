package com.primalkz.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @ld
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String review;

    @ManyToOne
    @JoinColumn(name="product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime createdAt;

}
