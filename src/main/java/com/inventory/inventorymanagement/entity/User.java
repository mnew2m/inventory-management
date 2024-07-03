package com.inventory.inventorymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventory.inventorymanagement.entity.enums.Yn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
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
    private String username;

    @Comment("비밀번호")
    @JsonIgnore
    private String password;

    @Comment("이메일")
    private String email;

    @Comment("휴대폰 번호")
    private String phone;

    @Comment("알람 주기")
    private Integer alarmCycle;

    @Comment("삭제 여부")
    @Enumerated(EnumType.STRING)
    private Yn deleteYn;

    @Comment("알람 여부")
    @Enumerated(EnumType.STRING)
    private Yn alarmYn;

    @Comment("이메일 수신 여부")
    @Enumerated(EnumType.STRING)
    private Yn emailYn;

    @Comment("SMS 수신 여부")
    @Enumerated(EnumType.STRING)
    private Yn smsYn;
}
