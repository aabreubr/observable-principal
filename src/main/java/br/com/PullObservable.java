package br.com;

import org.example.interfaces.Observable;
import org.example.interfaces.UseCase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnSingleCandidate(Observable.class)
public class PullObservable implements Observable {

    /** Nao pode ser injetado pelo spring para nao causar referencia circular*/
    private UseCase useCase;

    @Override
    public void setObservable(UseCase useCase) {
        this.useCase = (UseCaseImpl) useCase;
    }

    public void execute(String read) {
        this.useCase.response(read);
    }

}
