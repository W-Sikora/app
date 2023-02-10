package pl.wsikora.successbudget.v3.category.application;

import lombok.Value;


@Value
public class CategoryDto {

    Long categoryId;
    String title;
    Integer transactionType;

}
