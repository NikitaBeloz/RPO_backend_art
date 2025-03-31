package ru.bmstu.rpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.rpo.entity.Painting;

public interface PaintingRepository   extends JpaRepository<Painting, Long> {
}
