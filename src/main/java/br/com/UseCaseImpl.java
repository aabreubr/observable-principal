package br.com;

import org.example.interfaces.Observable;
import org.example.interfaces.UseCase;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UseCaseImpl implements UseCase {

    private ServiceTransfer serviceTransfer;
    private Observable pullObservable;

    public UseCaseImpl(ServiceTransfer serviceTransfer, Observable pullObservable) {
        this.serviceTransfer = serviceTransfer;
        this.pullObservable = pullObservable;
        this.pullObservable.setObservable(this);
    }

    public void execute() throws IOException {
        System.out.println("Recebendo as mensagens");
        String read = serviceTransfer.readCommandListener();
        System.out.println("Executando as regras de negócio !!! ");
        this.pullObservable.execute(read);
    }

    @Override
    public void response(String read) {
        System.out.println("--------->>>>> Enviando o retorno após processamento");
        serviceTransfer.writeCommandListener(read);
    }
}
