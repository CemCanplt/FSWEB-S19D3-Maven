package com.workintech.s19d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "member", schema = "bank")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    // ID değişkeni genelde Long olur. Eğer başka bir tür kullanıyorsan, bunu kendine göre değiştir.

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
