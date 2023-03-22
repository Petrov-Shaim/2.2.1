package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Иван", "Проскурин", "ivanpros@mail.ru"),new Car("BMV",23));
      userService.add(new User("Сергей", "Ефимов", "se@mail.ru"),new Car("Mercedes",13));
      userService.add(new User("Никита", "Ломовцев", "nikita223@mail.ru"),new Car("Mazda",31));
      userService.add(new User("Андрей", "Уваров", "evarov3@mail.ru"),new Car("Lada",04));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List <Car> cars = userService.listCars();
      for (Car car : cars) {
         System.out.println("Id = "+car.getId());
         System.out.println("First Name = "+car.getModel());
         System.out.println("Last Name = "+car.getSeries());
         System.out.println();
      }
      System.out.println(userService.carList("Tesla",01));

      context.close();
   }
}
