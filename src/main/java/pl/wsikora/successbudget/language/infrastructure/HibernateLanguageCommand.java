package pl.wsikora.successbudget.language.infrastructure;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.wsikora.successbudget.abstractutil.infrastructure.AbstractCommand;
import pl.wsikora.successbudget.language.application.command.LanguageCommand;
import pl.wsikora.successbudget.language.domain.Language;

@Service
@Transactional
class HibernateLanguageCommand extends AbstractCommand<Language> implements LanguageCommand {

    @Override
    protected Class<Language> entityClass() {

        return Language.class;
    }
}

