package com.example.testuser2.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "ip_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ipAddress;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private UserEntity user;

}
