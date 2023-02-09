package pl.wsikora.successbudget.v3.category.application;

public interface CategoryCommand {

    void save(CategoryAttributes categoryAttributes);

    void delete(Long categoryId);

}
