package ru.bmstu.rpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.rpo.entity.Museum;

public interface MuseumRepository   extends JpaRepository<Museum, Long> {
}
