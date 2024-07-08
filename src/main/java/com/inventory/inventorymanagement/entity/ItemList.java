package com.inventory.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ItemList extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Comment("카테고리seq")
    @OneToOne
    private Category category;

    @Comment("상품명")
    private String name;

    @Comment("구매처")
    private String site;

    @Comment("메모")
    private String memo;

    @Comment("수량")
    private int cnt;

    @Comment("구매일")
    private LocalDate boughtDate;

    @Comment("가격")
    private int price;
}
