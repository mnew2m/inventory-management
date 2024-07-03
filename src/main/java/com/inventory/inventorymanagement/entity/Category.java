package com.inventory.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Comment("유저seq")
    @ManyToOne
    private User user;

    @Comment("카테고리명")
    private String name;

    @Comment("순서")
    private int rank;
}