package mobyDickensBookStore.repository;

import mobyDickensBookStore.model.ApplicationUser;

public interface ApplicationUserRepository {

    ApplicationUser findUserByUserName(String username);

    ApplicationUser addUser(Integer id, String userName, String password, Boolean isBoolean);
}
