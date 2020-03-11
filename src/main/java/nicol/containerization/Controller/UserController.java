package nicol.containerization.Controller;

import nicol.containerization.Entity.UserEntity;
import nicol.containerization.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(final UserService userService){
    this.userService = userService;
  }

  @PostMapping(path="/add")
  public @ResponseBody String addUser(@RequestParam String firstName, @RequestParam String lastName) {
    userService.create(firstName, lastName);
    return "New User Created!";
  }

  @GetMapping(path="/get-all")
  public @ResponseBody Iterable<UserEntity> getAllUsers() {
    return userService.getAll();
  }
}
