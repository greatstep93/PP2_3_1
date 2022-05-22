package web;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
import web.model.User;
import web.service.UserService;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("Мария", "Лескова", "maria@mail.ru"));
      userService.add(new User("Дмитрий", "Горбачев", "dmitriy@mail.ru"));
      userService.add(new User("Алексей", "Сторожев", "alexey@mail.ru"));
      userService.add(new User("Александр", "Иванов", "alexandr@mail.ru"));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }


      context.close();
   }
}
