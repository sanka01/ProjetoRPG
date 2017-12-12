/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import camadabanco.BancoDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import static models.Personagem.isThere;

/**
 *
 * @author valdenor
 */
public class Personagem_has_atributos {

    private int valor;

    private int modificador;

    private int personagem_idpersonagem;

    private int atributos_idatributos;

    public static ArrayList<Personagem_has_atributos> consultaAtributosPersonagemBanco(String colunas, String condicao) throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        ArrayList<Personagem_has_atributos> listaPersonagem = new ArrayList<>();

        try {
            String sql = "Select " + colunas + " from personagem_has_atributos where " + condicao;
            System.out.println(sql);
            resultado = con.createStatement().executeQuery(sql);
            
            while (resultado.next()) {
                Personagem_has_atributos p = new Personagem_has_atributos();

                p.setValor(isThere(resultado, "valor") ? Integer.getInteger(resultado.getString("valor")) : 0);
                p.setPersonagem_idpersonagem(isThere(resultado, "personagem_idpersonagem") ? Integer.getInteger(resultado.getString("personagem_idpersonagem")) : 0);
                p.setModificador(isThere(resultado, "modificador") ? Integer.getInteger(resultado.getString("modificador")) : 0);
                p.setAtributos_idatributos(isThere(resultado, "atributos_idatributos") ? Integer.getInteger(resultado.getString("atributos_idatributos")) : 0);

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
     * Get the value of atributos_idatributos
     *
     * @return the value of atributos_idatributos
     */
    public int getAtributos_idatributos() {
        return atributos_idatributos;
    }

    /**
     * Set the value of atributos_idatributos
     *
     * @param atributos_idatributos new value of atributos_idatributos
     */
    public void setAtributos_idatributos(int atributos_idatributos) {
        this.atributos_idatributos = atributos_idatributos;
    }

    /**
     * Get the value of personagem_idpersonagem
     *
     * @return the value of personagem_idpersonagem
     */
    public int getPersonagem_idpersonagem() {
        return personagem_idpersonagem;
    }

    /**
     * Set the value of personagem_idpersonagem
     *
     * @param personagem_idpersonagem new value of personagem_idpersonagem
     */
    public void setPersonagem_idpersonagem(int personagem_idpersonagem) {
        this.personagem_idpersonagem = personagem_idpersonagem;
    }

    /**
     * Get the value of modificador
     *
     * @return the value of modificador
     */
    public int getModificador() {
        return modificador;
    }

    /**
     * Set the value of modificador
     *
     * @param modificador new value of modificador
     */
    public void setModificador(int modificador) {
        this.modificador = modificador;
    }

    /**
     * Get the value of valor
     *
     * @return the value of valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Set the value of valor
     *
     * @param valor new value of valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}
