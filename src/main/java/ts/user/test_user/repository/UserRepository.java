package ts.user.test_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ts.user.test_user.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
