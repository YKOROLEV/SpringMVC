package repository;

import model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @NotNull
    List<User> findAll();

    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);
}