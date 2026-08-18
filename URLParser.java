import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getWelcomeMessage(int userId) {
        String username = userRepository.findUsernameById(userId);

        return "Welcome, " + username + "!";
    }
}
