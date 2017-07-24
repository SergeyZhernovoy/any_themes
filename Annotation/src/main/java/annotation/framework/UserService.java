package annotation.framework;

/**
 * Created by Sergey on 24.07.2017.
 */
public interface UserService {

    User getUser(int userId);

    void setUser(User user);

}
