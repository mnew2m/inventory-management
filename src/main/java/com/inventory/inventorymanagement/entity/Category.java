package com.inventory.inventorymanagement.entity;

import com.inventory.inventorymanagement.entity.enums.CategoryType;
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
    private int categoryId;

    @Comment("유저seq")
    @ManyToOne
    private User user;

    @Comment("카테고리 타입")
    @Enumerated(EnumType.STRING)
    private CategoryType type;

    @Comment("카테고리명")
    private String name;

    @Comment("순서")
    private int seq;
}