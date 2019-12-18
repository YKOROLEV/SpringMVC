package service;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {

    private final UserDAO dao;

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public Optional<User> findById(Long id) {
        return dao.findById(id);
    }

    public Optional<User> findByLogin(String login) {
        return dao.findByLogin(login);
    }

    public boolean existsByLogin(String login) {
        return dao.existsByLogin(login);
    }

    public void save(User user) {
        dao.save(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public boolean deleteById(Long id) {
        return dao.deleteById(id);
    }
}