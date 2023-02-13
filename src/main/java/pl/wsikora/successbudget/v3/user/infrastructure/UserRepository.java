package pl.wsikora.successbudget.v3.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.common.type.username.Username;
import pl.wsikora.successbudget.v3.user.domain.User;

import java.util.Optional;


@Repository
interface UserRepository extends JpaRepository<User, Username> {

    @Query("""
        select u
        from User u
        where u.username.value = ?1
    """)
    Optional<User> findByUsernameAsString(String username);

    @Query("""
        select (count(u) > 0)
        from User u
        where u.username.value = ?1
    """)
    boolean existsByUsername(String username);

    @Query("""
        select u.majorCurrency
        from User u
        where u.username = ?1
    """)
    Optional<Integer> findMajorCurrency(Username username);

}
