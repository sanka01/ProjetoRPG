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
public class Raca {
    
    private String nome;

    private String classeFavorita;

    private int tamanho;
    
    private int idRaca;


    public static int contarRacas() throws ClassNotFoundException{
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        int total = 0;
        try {
            resultado = con.createStatement().executeQuery("select count(idraca) as total from Raca");
            while (resultado.next()) {
               total = Integer.valueOf(resultado.getString("total"));
                

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return total;
    }
     public static ArrayList<Raca> listarRaca() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        ArrayList<Raca> listaRaca = new ArrayList<>();
        try {
            resultado = con.createStatement().executeQuery("select * from Raca");
            while (resultado.next()) {
                Raca p = new Raca();
                p.setIdRaca(Integer.valueOf(resultado.getString("idraca")));
                p.setClasseFavorita();
                p.setNome(resultado.getString("nome"));
                p.setTamanho(Integer.valueOf(resultado.getString("tamanho")));
                listaRaca.add(p);
                

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listaRaca;
    }

    /**
     * Get the value of tamanho
     *
     * @return the value of tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Set the value of tamanho
     *
     * @param tamanho new value of tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Get the value of classeFavorita
     *
     * @return the value of classeFavorita
     */
    public String getClasseFavorita() {
        return classeFavorita;
    }

    /**
     * Set the value of classeFavorita
     *
     * @param classeFavorita new value of classeFavorita
     */
    public void setClasseFavorita() throws ClassNotFoundException {
         Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        
        try {
            resultado = con.createStatement().executeQuery(" select classe.nome from classe,raca where idclasse = classeFavorecida and idraca = " + idRaca);
            while (resultado.next()) {
               classeFavorita = resultado.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
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
     * Get the value of idRaca
     *
     * @return the value of idRaca
     */
    public int getIdRaca() {
        return idRaca;
    }

    /**
     * Set the value of idRaca
     *
     * @param idRaca new value of idRaca
     */
    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

}
