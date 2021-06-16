package kg.megacom.mythymeleaf.dao;

import kg.megacom.mythymeleaf.domain.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private static long UserID;

    private List<User> userList;

    {
        userList = new ArrayList<>();
    }

    public List<User> index() {
        return userList;
    }

    public User show(long id) {
        return userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setActive(true);
        user.setId(++UserID);
        userList.add(user);
    }

    public void updateUser(long id, User updatedUser) {
        User userToBeUpdated = show(id);
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == userToBeUpdated.getId()) {
                userToBeUpdated.setName(updatedUser.getName());
                userToBeUpdated.setEmail(updatedUser.getEmail());
                userToBeUpdated.setPassword(updatedUser.getPassword());
                break;
            }
        }
    }

        public void deleteUser (long id){
            userList.removeIf(user -> user.getId() == id);
        }
    }

