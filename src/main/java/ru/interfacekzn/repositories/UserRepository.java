package ru.interfacekzn.repositories;

import ru.interfacekzn.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author m.popov
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
