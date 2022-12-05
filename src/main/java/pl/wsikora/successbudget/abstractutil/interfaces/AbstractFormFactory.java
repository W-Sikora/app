package pl.wsikora.successbudget.abstractutil.interfaces;

public abstract class AbstractFormFactory<Form, Entity> {

    public abstract Form getForm(Long id);

    protected abstract Form convert(Entity entity);
}
