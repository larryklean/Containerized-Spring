package nicol.containerization.Service;

import nicol.containerization.Entity.UserEntity;
import nicol.containerization.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(final UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public void create(String firstName, String lastName) {
    UserEntity user = new UserEntity();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    userRepository.save(user);
  }

  public Iterable<UserEntity> getAll() {
    return userRepository.findAll();
  }
}
