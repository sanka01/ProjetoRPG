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

/**
 *
 * @author valdenor
 */
public class Personagem {

    private String nome;

    private int nivel;

    private String tendencia;

    private String divindade;

    private String descricao;

    private float deslocamento;

    private float pesoTotal;

    private int carga;

    private ArrayList idiomas;

    private int idPersonagem;

    private ArrayList<Atributos> atributos;

    private String raca;

    private ArrayList<Classe> classe;

    public Personagem() {
        this.nome = "";
        this.tendencia = "";
        this.divindade = "";
        this.descricao = "";
        this.deslocamento = 0;
        this.pesoTotal = 0;
        this.carga = 0;
        this.idiomas = null;
        this.idPersonagem = 0;
        this.atributos = null;
        this.raca = "";
        this.classe = null;
    }

    public static void delete(int id) throws ClassNotFoundException {
        try {
            Connection con = BancoDados.abreConexao();
            con.createStatement().execute("delete from personagem where idpersonagem = " + id);

        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }

    public static int getLastId() throws ClassNotFoundException {
        int id = 0;
        try {
            Connection con = BancoDados.abreConexao();
            ResultSet resultado = null;
            resultado = con.createStatement().executeQuery("Select max(idpersonagem) as id from personagem");
            resultado.next();
            id = Integer.valueOf(resultado.getString("id"));
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
        return id;
    }

    public String getRacaId() throws ClassNotFoundException {
        String raca = getRaca();
        
        try {
            Connection con = BancoDados.abreConexao();
            ResultSet resultado = null;
            String sql = "Select idraca from raca where nome = '" + raca + "'";
            resultado = con.createStatement().executeQuery(sql);
            System.out.println(sql);
            resultado.next();
            raca = resultado.getString("idraca");
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
        return raca;
    }

    public void update() throws ClassNotFoundException {
        try {
            Connection con = BancoDados.abreConexao();
            con.createStatement().execute("Update Personagem set "
                    + "nome = '" + nome + "',tendencia = '" + tendencia + "',divindade = '" + divindade + "',descricao = '" + descricao + "',raca = " + getRacaId() + " where idpersonagem = " + idPersonagem);
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }

    public void salvar() throws ClassNotFoundException {
        try {
            int id = getLastId()+1;
            Connection con = BancoDados.abreConexao();
            con.createStatement().execute("Insert Into Personagem(idpersonagem,nome,tendencia,divindade,descricao,raca) "
                    + "Values("+ id +",'" + nome + "','" + tendencia + "','" + divindade + "','" + descricao + "'," + getRacaId() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
    }

    public static String contaPersonagem() throws ClassNotFoundException {
        String total = "0";
        try {
            Connection con = BancoDados.abreConexao();
            ResultSet resultado = null;
            resultado = con.createStatement().executeQuery("Select count(idpersonagem) as total from personagem");
            resultado.next();
            total = resultado.getString("total");
        } catch (SQLException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BancoDados.fechaConexao();
        }
        return total;
    }

    public static Personagem findByNome(String nome) throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        Personagem personagem = new Personagem();
        try {
            resultado = con.createStatement().executeQuery("select * from Personagem where nome = '" + nome + "'");
            if (resultado.next()) {
                personagem.setIdPersonagem(Integer.valueOf(resultado.getString("idpersonagem")));
                personagem.setNome(resultado.getString("nome"));
                personagem.setAtributos();
                personagem.setRaca();
                personagem.setTendencia(isThere(resultado, "tendencia") ? resultado.getString("tendencia") : "");
                personagem.setDivindade(isThere(resultado, "divindade") ? resultado.getString("divindade") : "");
                personagem.setDescricao(isThere(resultado, "descricao") ? resultado.getString("descricao") : "");
                personagem.setClasse();
                personagem.setNivel();
            } else {
                personagem = null;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        return personagem;
    }

    public static Personagem findById(int id) throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        Personagem personagem = new Personagem();
        try {
            resultado = con.createStatement().executeQuery("select * from Personagem where idpersonagem = " + id);
            resultado.next();
            personagem.setIdPersonagem(Integer.valueOf(resultado.getString("idpersonagem")));
            personagem.setNome(resultado.getString("nome"));
            personagem.setAtributos();
            personagem.setRaca();
            personagem.setClasse();
            personagem.setNivel();
            personagem.setTendencia(isThere(resultado, "tendencia") ? resultado.getString("tendencia") : "");
            personagem.setDivindade(isThere(resultado, "divindade") ? resultado.getString("divindade") : "");
            personagem.setDescricao(isThere(resultado, "descricao") ? resultado.getString("descricao") : "");

        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        return personagem;
    }

    public static ArrayList<Personagem> listarPersonagem() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        ArrayList<Personagem> listaPersonagem = new ArrayList<>();
        try {
            resultado = con.createStatement().executeQuery("select * from Personagem");
            while (resultado.next()) {
                Personagem p = new Personagem();
                p.setIdPersonagem(Integer.valueOf(resultado.getString("idpersonagem")));
                p.setNome(resultado.getString("nome"));
                p.setAtributos();
                p.setRaca();
                p.setClasse();
                p.setNivel();
                listaPersonagem.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        return listaPersonagem;
    }

// metodo que verifica se existe determinada coluna em um ResultSet
    public static boolean isThere(ResultSet rs, String column) {
        try {
            rs.findColumn(column);
            return true;
        } catch (SQLException sqlex) {
        }
        return false;
    }

    /**
     * Set the value of atributos
     *
     * @param atributos new value of atributos
     */
    public void setAtributos() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;

        atributos = new ArrayList<Atributos>();

        try {
            resultado = con.createStatement().executeQuery("select nome,valor,modificador from atributos,personagem_has_atributos where personagem_has_atributos.personagem_idpersonagem = " + idPersonagem + " and "
                    + "atributos_idatributos = idatributos");
            while (resultado.next()) {
                Atributos atr = new Atributos();
                atr.setNome(resultado.getString("nome"));
                atr.setValor(Integer.valueOf(resultado.getString("valor")));
                atr.setModificador(Integer.valueOf(resultado.getString("modificador")));
                atributos.add(atr);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }

    }

    /**
     * Get the value of classe
     *
     * @return the value of classe
     */
    public ArrayList<Classe> getClasse() {
        return classe;
    }

    /**
     * Set the value of classe
     *
     * @param classe new value of classe
     */
    public void setClasse() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        classe = new ArrayList<Classe>();
        try {
            resultado = con.createStatement().executeQuery(" select idclasse,nome,nivel from classe,nivelclasse where "
                    + "personagem_idpersonagem = " + idPersonagem + " and "
                    + "classe_idclasse = idclasse");
            while (resultado.next()) {
                Classe classe = new Classe();
                classe.setNome(resultado.getString("nome"));
                classe.setIdClasse(Integer.valueOf(resultado.getString("idclasse")));
                classe.setNivel(Integer.valueOf(resultado.getString("nivel")));
                this.classe.add(classe);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
    }

    /**
     * Get the value of atributos
     *
     * @return the value of atributos
     */
    public ArrayList<Atributos> getAtributos() {

        return atributos;
    }

    private void setPesoTotal(float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    /**
     * Get the value of raca
     *
     * @return the value of raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * Set the value of raca
     *
     * @param raca new value of raca
     */
    public void setRaca() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        try {
            resultado = con.createStatement().executeQuery("select raca.nome from raca,personagem where idraca = personagem.raca and idpersonagem =" + idPersonagem);
            while (resultado.next()) {
                raca = resultado.getString("nome");

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
    }

    /**
     * Get the value of idPersonagem
     *
     * @return the value of idPersonagem
     */
    public int getIdPersonagem() {
        return idPersonagem;
    }

    /**
     * Set the value of idPersonagem
     *
     * @param idPersonagem new value of idPersonagem
     */
    public void setIdPersonagem(int id) {
        this.idPersonagem = id;
    }

    public void setIdPersonagem() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        int id = 0;
        try {
            resultado = con.createStatement().executeQuery("select max(idpersonagem) as id from Personagem");
            while (resultado.next()) {
                id = Integer.valueOf(resultado.getString("id"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
        }
        this.idPersonagem = id;
    }

    public ArrayList getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList idiomas) {
        this.idiomas = idiomas;
    }

    /**
     * Get the value of carga
     *
     * @return the value of carga
     */
    public int getCarga() {
        return carga;
    }

    /**
     * Set the value of carga
     *
     * @param carga new value of carga
     */
    public void setCarga(int carga) {
        this.carga = carga;
    }

    /**
     * Get the value of pesoTotal
     *
     * @return the value of pesoTotal
     */
    public float getPesoTotal() {
        return pesoTotal;
    }

    /**
     * Get the value of deslocamento
     *
     * @return the value of deslocamento
     */
    public float getDeslocamento() {
        return deslocamento;
    }

    /**
     * Set the value of deslocamento
     *
     * @param deslocamento new value of deslocamento
     */
    public void setDeslocamento(float deslocamento) {
        this.deslocamento = deslocamento;
    }

    /**
     * Get the value of descricao
     *
     * @return the value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set the value of descricao
     *
     * @param descricao new value of descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Get the value of divindade
     *
     * @return the value of divindade
     */
    public String getDivindade() {
        return divindade;
    }

    /**
     * Set the value of divindade
     *
     * @param divindade new value of divindade
     */
    public void setDivindade(String divindade) {
        this.divindade = divindade;
    }

    /**
     * Get the value of tendencia
     *
     * @return the value of tendencia
     */
    public String getTendencia() {
        return tendencia;
    }

    /**
     * Set the value of tendencia
     *
     * @param tendencia new value of tendencia
     */
    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
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
    public void setNivel() throws ClassNotFoundException {
        Connection con = BancoDados.abreConexao();
        ResultSet resultado = null;
        try {
            String sql = "select sum(nivelclasse.nivel) as total from nivelclasse where nivelclasse.personagem_idpersonagem =  " + idPersonagem;
            resultado = con.createStatement().executeQuery(sql);
            while (resultado.next()) {
                nivel = Integer.valueOf(resultado.getString("total"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }finally{
            BancoDados.fechaConexao();
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

    public void setRaca(String raca) {
        this.raca = raca;
    }

}
