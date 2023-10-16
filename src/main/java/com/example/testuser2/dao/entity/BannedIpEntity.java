package com.example.testuser2.dao.entity;

import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "banned_ips")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannedIpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ipAddress;
    private LocalDate bannedUntil;
}
