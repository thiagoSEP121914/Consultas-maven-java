package org.example;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        ContatoDAO dao = new ContatoDAO();

        Contato contato = new Contato();
        contato.setNome("Gordinho");
        contato.setIdade(25);
        contato.setDatacadastro(new Date());
        contato.setId(2);

        dao.deleteContato(1);

    for (Contato contatinho : dao.getContato()) {
        System.out.println("Contato: " + contatinho);
    }

    }

}