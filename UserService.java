import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
/**
 * UserService.java
 *
 * This service class depends on UserRepository to do its job.
 * The dependency is provided through the CONSTRUCTOR, which is
 * called "constructor injection". Spring automatically supplies
 * a UserRepositoryImpl object when it creates this UserService.
 */
@Service
public class UserService {
 
    private final UserRepository userRepository;
 
    // Constructor injection: Spring passes in the UserRepository here
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    public String getWelcomeMessage(int userId) {
        String username = userRepository.findUsernameById(userId);
        return "Welcome, " + username + "!";
    }
}
