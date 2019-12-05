package mobyDickensBookStore.service.impl;

import mobyDickensBookStore.model.ApplicationUser;
import mobyDickensBookStore.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser findUserByUserName(String username) {
        return applicationUserRepository.findUserByUserName(username);
    }
}
