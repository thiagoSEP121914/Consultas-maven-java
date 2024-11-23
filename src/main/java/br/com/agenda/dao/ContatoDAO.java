package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;
import jdk.jfr.DataAmount;

import java.rmi.ConnectException;
import java.rmi.server.ExportException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class ContatoDAO {


    public List<Contato> getContato() throws Exception {

        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<>();

        Connection conn = null;

        PreparedStatement pstm = null;

        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnection();

            pstm = conn.prepareStatement(sql);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();

                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setIdade(rs.getInt("idade"));
                contato.setDatacadastro(rs.getDate("datacadastro"));

                contatos.add(contato);

            }
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    pstm.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
        return contatos;
    }

    public void addContato(Contato contato) throws Exception {
        // variavel que ira receber a consulta
        String sql = "INSERT INTO contatos (nome, idade, datacadastro) VALUES (?, ?, ?)";

        //conexao com o banco de dados
        Connection conn = null;

        //Variavel que irá executar a consulta
        PreparedStatement pstm = null;


        try {
            //conexao com o banco de dados
            conn = ConnectionFactory.createConnection();

            //Variavel que irá executar a consulta
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDatacadastro().getTime()));
            pstm.execute();
            System.out.println("CONTATO SALVO COM SUCESSO!");
        } catch (Exception error) {
            error.printStackTrace();
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }

    }

    public void updateContato(Contato contato) throws Exception {
        String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ?" +
                     "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDatacadastro().getTime()));
            pstm.setInt(4, contato.getId());
            pstm.execute();
            System.out.println("CONTATOS MARAVILHOS ATUALIZADOS");
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
    }

    public void deleteContato (int id) throws Exception {
        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("CONTATO EXCLUIDO COM SUCESSO!");
        } catch (Exception error) {
            error.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception error) {
                error.printStackTrace();
            }
        }
    }

}
