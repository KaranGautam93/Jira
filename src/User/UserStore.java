package User;

import java.util.*;

public class UserStore {

    private Map users;

    public UserStore()
    {
        this.users = new HashMap<Integer,Users>();
    }

    public Users createUser(String name, String email)
    {
        Users user = new Users();
        user.setName(name);
        Random rand = new Random();
        user.setId(Math.abs((int) (new Date().getTime())) + rand.nextInt());
        user.setEmail(email);
        users.put(user.getId(),user);
        return user;
    }
}
