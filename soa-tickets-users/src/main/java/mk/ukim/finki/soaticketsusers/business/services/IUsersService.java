package mk.ukim.finki.soaticketsusers.business.services;


import mk.ukim.finki.soaticketsusers.business.view.models.user.RegisterUserViewModel;
import mk.ukim.finki.soaticketsusers.business.view.models.user.UpdateUserViewModel;
import mk.ukim.finki.soaticketsusers.business.view.models.user.UserViewModel;

import java.util.List;

public interface IUsersService {
    List<UserViewModel> getAll();
    UserViewModel getById(Long userId) throws Exception;
    Long register(RegisterUserViewModel user) throws Exception;
    Long update(UpdateUserViewModel user);
    Long delete(Long userId) throws Exception;
    UserViewModel findByEmail(String email) throws Exception;
    UserViewModel findByUsername(String username) throws Exception;
}
