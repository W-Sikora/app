package pl.wsikora.successbudget.v3.category.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsikora.successbudget.v3.common.type.Username;
import pl.wsikora.successbudget.v3.user.domain.User;


@Repository
interface UserCrudRepository extends CrudRepository<User, Username> {

}
