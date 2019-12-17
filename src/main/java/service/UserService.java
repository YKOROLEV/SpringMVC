package service;

import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void save(User user) {
        repository.save(user);
    }

    public boolean existsByLogin(String login) {
        return repository.existsByLogin(login);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}