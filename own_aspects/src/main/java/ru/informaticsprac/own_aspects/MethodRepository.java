package ru.informaticsprac.own_aspects;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MethodRepository extends JpaRepository<Method, Long> {
    Optional<Method> findEntityByUuidAndParametersAndName(String uuid, String parameters, String name);

    Optional<Method> findEntityByName(String name);
}
