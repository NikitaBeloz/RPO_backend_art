package ru.bmstu.rpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bmstu.rpo.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
