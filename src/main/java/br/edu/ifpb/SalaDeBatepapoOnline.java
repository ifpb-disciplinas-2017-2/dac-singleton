package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/12/2017, 07:20:10
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
//@DependsOn("SalaDeBatepapoOnline2")
public class SalaDeBatepapoOnline {

    private List<String> mensagens = new ArrayList<>();

    public void novaMensagem(String mensagem) {
        System.out.println("antes");
        synchronized (mensagens) {
            mensagens.add(mensagem);
        }
        System.out.println("depois");
    }

    public synchronized void removerMensagem(String mensagem) {
        mensagens.remove(mensagem);
    }

    public List<String> historico() {
        return Collections.unmodifiableList(mensagens);
    }

}
