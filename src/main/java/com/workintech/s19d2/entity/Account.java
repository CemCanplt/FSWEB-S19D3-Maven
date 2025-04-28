package com.workintech.s19d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account", schema = "bank")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Long id;
    // ID değişkeni genelde Long olur. Eğer başka bir tür kullanıyorsan, bunu kendine göre değiştir.

    @Column(name = "name")
    private String name;
}
