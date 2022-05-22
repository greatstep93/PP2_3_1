package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   List<User> listUsers();

   public void removeUserById(long id);

   public User showUserById(int id);

   public void update(long id,User updateUser);
}
