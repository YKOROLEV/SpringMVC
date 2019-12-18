package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);

    void save(User user);

    void update(User user);

    boolean deleteById(Long id);
}