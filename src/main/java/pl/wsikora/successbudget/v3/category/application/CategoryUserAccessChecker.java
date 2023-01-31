package pl.wsikora.successbudget.v3.category.application;

import pl.wsikora.successbudget.v3.common.type.CategoryId;
import pl.wsikora.successbudget.v3.common.type.Username;


public interface CategoryUserAccessChecker {

    boolean hasAccess(CategoryId categoryId, Username username);
}
