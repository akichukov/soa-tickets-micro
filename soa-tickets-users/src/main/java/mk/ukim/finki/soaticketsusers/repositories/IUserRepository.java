package mk.ukim.finki.soaticketsusers.repositories;

import mk.ukim.finki.soaticketsusers.models.user.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}