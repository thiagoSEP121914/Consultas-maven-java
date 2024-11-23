package br.com.agenda.model;

import javax.swing.plaf.PanelUI;
import java.util.Date;

public class Contato {

    private int id;
    private String nome;
    private int idade;

    private Date datacadastro;

    public Contato (String nome, int idade, Date datacadastro) {
        this.nome = nome;
        this.idade = idade;
        this.datacadastro = datacadastro;
    }

    public Contato () {

    }

    public int getId() {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String toString () {
        return getId() + " " + getNome() + " " + getIdade()+ " " + getDatacadastro();
    }


}
