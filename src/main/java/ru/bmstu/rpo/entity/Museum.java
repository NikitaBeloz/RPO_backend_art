package ru.bmstu.rpo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "museum")
public class Museum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public long id;

    @Column(name = "name", nullable = false, length = 128)
    public String name;

    @Column(name = "location", nullable = false, length = 128)
    public String location;

    @JsonIgnore
    @OneToMany(mappedBy = "museum")
    public List<Painting> paintings = new ArrayList<>();
}
