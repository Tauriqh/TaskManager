package za.ac.cput.repository.userDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.userDetails.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
