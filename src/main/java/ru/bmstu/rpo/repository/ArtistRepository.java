package ru.bmstu.rpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.rpo.entity.Artist;

public interface ArtistRepository   extends JpaRepository<Artist, Long> {
}
