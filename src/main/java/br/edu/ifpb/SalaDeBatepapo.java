package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/12/2017, 07:20:10
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
@Startup
@DependsOn("SalaDeBatepapoOnline")
public class SalaDeBatepapo {

    private List<String> mensagens = new ArrayList<>();

    @Lock(LockType.WRITE)
    public void novaMensagem(String mensagem) {
        System.out.println("antes");
        mensagens.add(mensagem);
        System.out.println("depois");
    }

    @Lock(LockType.WRITE)
    public void removerMensagem(String mensagem) {
        mensagens.remove(mensagem);
    }

    public List<String> historico() {
        return Collections.unmodifiableList(mensagens);
    }

}
