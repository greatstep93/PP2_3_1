package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public void removeUserById(long id){
      Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM User where id = :idCode");
      query.setParameter("idCode", id);
      query.executeUpdate();
   }



//   @Override
//   public void removeUserById(long id) {
//      try (Session session = sessionFactory.getCurrentSession()) {
//         session.getTransaction().begin();
//
//         session.createQuery("DELETE FROM User WHERE id = " + id).executeUpdate();
//         try {
//            session.getTransaction().commit();
//         } catch (Exception e){
//            session.getTransaction().rollback();
//         }
//
//      } catch (Exception e) {
//         System.out.println("Ошибка удаления пользователя по id");
//         e.printStackTrace();
//      }
//   }

   public User showUserById(int id){
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where id = " + id);
      return query.getSingleResult();
   }

   public void update(long id, User updateUser){
      Query query = sessionFactory.getCurrentSession().createQuery("update User set firstName = :nameParam, lastName = :lastNameParam" +
                 ", email = :emailParam"+
                 " where id = :idCode");
         query.setParameter("idCode", id);
         query.setParameter("nameParam", updateUser.getFirstName());
         query.setParameter("lastNameParam", updateUser.getLastName() );
         query.setParameter("emailParam",updateUser.getEmail() );
         query.executeUpdate();

   }

}
