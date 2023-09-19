package org.javarush.oleksandr.l7mvclive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    @Enumerated(EnumType.STRING)
    private Race race;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Boolean banned;
    private Integer experience;
    private Integer level;
    private Integer untilNextLevel;

}