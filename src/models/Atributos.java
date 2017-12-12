/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import camadabanco.BancoDados;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valdenor
 */
public class Atributos {
    
    private String nome;

    private int valor;

    private int modificador;

    private int idAtributo;

    public Atributos() {
        this.nome = "";
        this.valor = 0;
        this.modificador = 0;
        this.idAtributo = 0;
    }



        
     public static void  update(Atributos[] atr, int pj ) throws ClassNotFoundException{
         try {
            Connection con = BancoDados.abreConexao();
             for (int i = 0; i < atr.length; i++) {
                  con.createStatement().execute("update personagem_has_atributos set valor = "+ atr[i].getValor() + " where personagem_idpersonagem = " + pj+" and atributos_idatributos = " + atr[i].getIdAtributo());
             }
           
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }
    
     public void salvar(int id) throws ClassNotFoundException{
         try {
            Connection con = BancoDados.abreConexao();
            String sql = "Insert Into personagem_has_atributos(atributos_idatributos,personagem_idpersonagem,valor) values("+ idAtributo +", "+ id +","+ valor +")";
             System.out.println(sql);
            con.createStatement().execute(sql);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }
     
     
     /**
     * Get the value of idAtributo
     *
     * @return the value of idAtributo
     */
    public int getIdAtributo() {
        return idAtributo;
    }

    /**
     * Set the value of idAtributo
     *
     * @param idAtributo new value of idAtributo
     */
    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
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

}
