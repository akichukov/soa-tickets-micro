package mk.ukim.finki.soaticketsusers.repositories;

import mk.ukim.finki.soaticketsusers.models.user.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}