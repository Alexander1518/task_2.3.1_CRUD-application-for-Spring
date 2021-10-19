package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query=entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user){
        entityManager.merge(user);
    }
    @Override
    public User getUser(long id){
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id);
        return query.getSingleResult();
    }
}