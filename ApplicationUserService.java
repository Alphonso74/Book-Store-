package mobyDickensBookStore.service.impl;

import mobyDickensBookStore.model.ApplicationUser;

public interface ApplicationUserService {
    ApplicationUser findUserByUserName(String username);
}
