package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/12/2017, 07:30:26
 */
@Named
@RequestScoped
public class ControladorDeBatePapo {

//    private List<String> lista;
    @Inject
    private SalaDeBatepapo sala;

    private String mensagem;

    public String add() {
        sala.novaMensagem(mensagem);
        mensagem = "";
        return null;
    }

    public String remove(String msg) {
        sala.removerMensagem(msg);
//        lista.remove(msg);
        return null;
    }

    public List<String> mensagens() {
//        return lista;
        return sala.historico();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

//        @PostConstruct
//    public void init() {
//        lista = new ArrayList();
//        lista.add("Oi");
//        sala.novaMensagem("Oi :)");
//        sala.novaMensagem("Oi!!!!");
//        sala.novaMensagem("Oooooooooooooooi");
//    }
    
    
}
