package annotation.framework;

/**
 * Created by Sergey on 24.07.2017.
 */
public class UserAccounter {

    private UserService userService;


    public UserAccounter(UserService userService){
        this.userService = userService;
    }

    public void prinUser(){

    }

    public void generateUsers(){
        for (int index = 0; index < 5; index++){
            User user = new User();
            user.setUserName("_"+index);
            user.setUserPassword("_" + "+" + index);
        }

    }


}
