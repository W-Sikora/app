package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.domain.User;


@Repository
interface UserRepository extends JpaRepository<User, Username> {

    @Query("select u from User u where u.username.value = ?1")
    User getByUsernameAsString(String username);

    @Query("select (count(u) > 0) from User u where u.username.value = ?1")
    boolean existsByUsernameAsString(String username);

    @Query("select (count(u) > 0) from User u where u.username = ?1")
    boolean existsByUsername(Username username);
}
