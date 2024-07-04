package com.inventory.inventorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventory.inventorymanagement.entity.enums.Yn;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;

    @Comment("아이디")
    @Column(unique = true, length = 20)
    private String userId;

    @Comment("이름")
    @Column(length = 10)
    private String username;

    @Comment("비밀번호")
    @Column(length = 40)
    @JsonIgnore
    private String password;

    @Comment("삭제 여부")
    @Enumerated(EnumType.STRING)
    private Yn deleteYn;
}
