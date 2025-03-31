package ru.bmstu.rpo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public long id;

    @Column(name = "name", nullable = false, unique = true, length = 128)
    public String name;

    @Column(name = "century", nullable = false, length = 45)
    public String century;

    @ManyToOne()
    @JoinColumn(name = "country_id")
    public Country country;

    @OneToMany(mappedBy = "artist")
    public List paintings = new ArrayList();
}
