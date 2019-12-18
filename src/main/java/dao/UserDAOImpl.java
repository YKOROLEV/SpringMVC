package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        Query query = em.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
        Query query = em.createQuery("from User where id = :id");
        query.setParameter("id", id);

        return Optional.of((User) query.getSingleResult());
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Query query = em.createQuery("from User where login = :login");
        query.setParameter("login", login);

        return Optional.of((User) query.getSingleResult());
    }

    @Override
    public boolean existsByLogin(String login) {
        Query query = em.createQuery("select case when (count(id) > 0) then true else false end from User where login = :login");
        query.setParameter("login", login);
        return (boolean) query.getSingleResult();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public boolean deleteById(Long id) {
        Query query = em.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        return query.executeUpdate() > 0;
    }
}