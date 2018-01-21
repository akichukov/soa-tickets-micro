package mk.ukim.finki.soaticketsusers.business.services.implementation;

import mk.ukim.finki.soaticketsusers.business.services.IUsersService;
import mk.ukim.finki.soaticketsusers.business.view.models.user.RegisterUserViewModel;
import mk.ukim.finki.soaticketsusers.business.view.models.user.UpdateUserViewModel;
import mk.ukim.finki.soaticketsusers.business.view.models.user.UserViewModel;
import mk.ukim.finki.soaticketsusers.models.user.Role;
import mk.ukim.finki.soaticketsusers.models.user.User;
import mk.ukim.finki.soaticketsusers.repositories.IRoleRepository;
import mk.ukim.finki.soaticketsusers.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements IUsersService { // UserDetailsService
    @Autowired
    private IUserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private IRoleRepository roleRepository;

    private ModelMapper modelMapper;

    public UsersService(){
        modelMapper = new ModelMapper();
    }

    @Override
    public List<UserViewModel> getAll() {
        List<UserViewModel> result = new ArrayList<>();
        for (User user : userRepository.findAll())
            result.add(modelMapper.map(user, UserViewModel.class));

        return result;
    }

    @Override
    public UserViewModel getById(Long userId) throws Exception {
        User dboUser = userRepository.findOne(userId);
        if (dboUser == null)
            throw new Exception("There is no such user!");

        return modelMapper.map(dboUser, UserViewModel.class);
    }

    @Override
    public Long register(RegisterUserViewModel user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new Exception("User already exists!");

//        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        String encodedPassword = user.getPassword();
        User dboUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), encodedPassword, user.getPhoneNumber());

        Role standardUserRole = roleRepository.findByName("user");
        if (standardUserRole == null){
            standardUserRole = new Role("user");
            roleRepository.save(standardUserRole);
        }

        dboUser.addRole(standardUserRole);

        return userRepository.save(dboUser).getId();
    }

    @Override
    public Long update(UpdateUserViewModel user) {
        User dboUser = userRepository.findOne(user.getId());
        dboUser.setFirstName(user.getFirstName());
        dboUser.setLastName(user.getLastName());
        dboUser.setEmail(user.getEmail());
        dboUser.setPassword(user.getPassword());
        dboUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(dboUser);

        return dboUser.getId();
    }

    @Override
    public Long delete(Long userId) throws Exception {
        if (userId < 1)
            throw new Exception("The id has to be greater than 0!");

        userRepository.delete(userId);

        return userId;
    }

    @Override
    public UserViewModel findByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new Exception("There is no user associated with that email!");

        return modelMapper.map(user, UserViewModel.class);
    }

    @Override
    public UserViewModel findByUsername(String username) throws Exception {
        User user = userRepository.findByEmail(username);
        if (user == null)
            throw new Exception("The username does not exist!");

        return modelMapper.map(user, UserViewModel.class);
    }


    /**
     * We are not supporting the concept of logging in by username, so that's why everywhere You're about to see username, we're using the email instead.
     * @param s (should be username, but since it's not supported by this app, what this really is an email)
     * @return UserDetails if the user is successfully authenticated, exception is thrown otherwise
     * @throws UsernameNotFoundException
     */
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(s);
//        if (user == null) {
//            throw new UsernameNotFoundException(s);
//        }
//
//        return new AuthenticatedUser(user);
//    }
}