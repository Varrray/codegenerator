package com.project.codegenerator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "Id")
    private Long Id;
    @Column(name="email")
    private String email;
    @Column(name="password_hash")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="avatar_url")
    private String avatarUrl;
    @Column(name="create_at")
    private Instant createAt;
    @Column(name="update_at")
    private Instant updateAt;
    @Column(name="delete_at")
    private Instant deletedAt;


}
