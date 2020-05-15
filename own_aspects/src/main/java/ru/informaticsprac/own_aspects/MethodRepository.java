package ru.informaticsprac.own_aspects;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MethodRepository extends JpaRepository<Method, Long> {
    Optional<Method> findEntityByUuid(String uuid);

    Optional<Method> findEntityByName(String name);
}
