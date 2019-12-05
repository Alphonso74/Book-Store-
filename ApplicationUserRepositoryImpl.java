package mobyDickensBookStore.repository.impl;

import com.google.common.collect.MoreCollectors;
import mobyDickensBookStore.model.ApplicationUser;
import mobyDickensBookStore.repository.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    //
    //  Instance Data
    private List<ApplicationUser> applicationUserList = new ArrayList<>();

    @Override
    public ApplicationUser findUserByUserName(String username) {
        return applicationUserList.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public ApplicationUser addUser(Integer id, String userName, String password, Boolean isAdmin) {
        ApplicationUser user = new ApplicationUser(id, userName, password, isAdmin);
        applicationUserList.add(user);
        return user;
    }
}
