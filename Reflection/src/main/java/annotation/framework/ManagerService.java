package annotation.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 24.07.2017.
 */
@Component
public class ManagerService implements UserService {

    private List<User> users;

    public ManagerService(){
        this.users = new ArrayList<>();
    }

    @Override
    public User getUser(int userId) {
        return this.users.get(userId);

    }

    @Override
    public void setUser(User user) {
        this.users.add(user);
    }
}
