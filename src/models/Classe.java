/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import camadabanco.BancoDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static models.Personagem.isThere;

/**
 *
 * @author valdenor
 */
public class Classe {

    private String nome;

    private int fortitude;

    private int reflexos;

    private int vontade;

    private int nivel;

    private int idClasse;

    public void update(int nivel, int id) throws ClassNotFoundException {
        try {
            Connection con = BancoDados.abreConexao();
            con.createStatement().execute("update nivelclasse set nivel = " + nivel + " where personagem_idpersonagem = " + id);
        } catch (SQLException ex) {
        }finally{
            BancoDados.fechaConexao();
        }
    }

    public void salvar(int id) throws ClassNotFoundException {
        try {
            Connection con = BancoDados.abreConexao();
            con.createStatement().execute("Insert Into nivelclasse(classe_idclasse , personagem_idpersonagem, nivel) "
                    + "values("
                    + idClasse + ", "
                    + id + ", "
                    + "1)");
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }

    public static int contarClasses() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        int total = 0;
        try {
            resultado = con.createStatement().executeQuery("select count(idclasse) as total from Classe");
            while (resultado.next()) {
                total = Integer.valueOf(resultado.getString("total"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        return total;
    }

    public static ArrayList<Classe> listarClasse() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        ArrayList<Classe> listaClasse = new ArrayList<>();
        try {
            resultado = con.createStatement().executeQuery("select * from Classe");
            while (resultado.next()) {
                Classe p = new Classe();
                p.setIdClasse(Integer.valueOf(resultado.getString("idclasse")));
                p.setNome(resultado.getString("nome"));
                p.setFortitude(Personagem.isThere(resultado, "fortitude") ? Integer.valueOf(resultado.getString("fortitude")) : 0);
                p.setReflexos(Personagem.isThere(resultado, "reflexos") ? Integer.valueOf(resultado.getString("reflexos")) : 0);
                p.setVontade(Personagem.isThere(resultado, "vontade") ? Integer.valueOf(resultado.getString("vontade")) : 0);
                p.setNivel(Personagem.isThere(resultado, "nivel") ? Integer.valueOf(resultado.getString("nivel")) : 1);
                listaClasse.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        return listaClasse;
    }

    /**
     * Get the value of nivel
     *
     * @return the value of nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Set the value of nivel
     *
     * @param nivel new value of nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public static ArrayList<Classe> consultaClasseBanco(String colunas, String condicao) throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        ArrayList<Classe> listaPersonagem = new ArrayList<>();

        try {
            resultado = con.createStatement().executeQuery("Select " + colunas + " from classe where " + condicao);

            while (resultado.next()) {
                Classe p = new Classe();

                p.setFortitude(isThere(resultado, "fortitude") ? Integer.getInteger(resultado.getString("fortitude")) : 0);
                p.setNome(isThere(resultado, "nome") ? resultado.getString("nome") : "");
                p.setReflexos(isThere(resultado, "reflexos") ? Integer.getInteger(resultado.getString("reflexos")) : 0);
                p.setVontade(isThere(resultado, "vontade") ? Integer.getInteger(resultado.getString("vontade")) : 0);

                listaPersonagem.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BancoDados.fechaConexao();
        }
        return listaPersonagem;
    }

    /**
     * Get the value of vontade
     *
     * @return the value of vontade
     */
    public int getVontade() {
        return vontade;
    }

    /**
     * Set the value of vontade
     *
     * @param vontade new value of vontade
     */
    public void setVontade(int vontade) {
        this.vontade = vontade;
    }

    /**
     * Get the value of reflexos
     *
     * @return the value of reflexos
     */
    public int getReflexos() {
        return reflexos;
    }

    /**
     * Set the value of reflexos
     *
     * @param reflexos new value of reflexos
     */
    public void setReflexos(int reflexos) {
        this.reflexos = reflexos;
    }

    /**
     * Get the value of fortitude
     *
     * @return the value of fortitude
     */
    public int getFortitude() {
        return fortitude;
    }

    /**
     * Set the value of fortitude
     *
     * @param fortitude new value of fortitude
     */
    public void setFortitude(int fortitude) {
        this.fortitude = fortitude;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get the value of idClasse
     *
     * @return the value of idClasse
     */
    public int getIdClasse() {
        return idClasse;
    }

    /**
     * Set the value of idClasse
     *
     * @param idClasse new value of idClasse
     */
    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

}
