package pl.wsikora.successbudget.v3.category.application;

import lombok.Value;
import pl.wsikora.successbudget.v3.common.type.url.UrlDto;


@Value
public class CategoryDto {

    Long categoryId;
    String title;
    Integer transactionType;
    UrlDto urlDto;

}
