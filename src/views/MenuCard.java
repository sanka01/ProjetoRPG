/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import img.FundoBg;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import models.Atributos;
import models.Classe;
import models.Personagem;
import models.Raca;
import static models.Raca.listarRaca;

/**
 *
 * @author valdenor
 */
public class MenuCard extends javax.swing.JFrame {

    public String[] listarClasses() throws ClassNotFoundException {
        ArrayList<Classe> lista = Classe.listarClasse();
        String[] listaClasse = new String[Classe.contarClasses()];
        int i = 0;
        for (Classe classe : lista) {
            listaClasse[i] = classe.getNome();
            i++;
        }
        return listaClasse;
    }

    public String[] listarRaca() throws ClassNotFoundException {
        ArrayList<Raca> lista = Raca.listarRaca();
        String[] listaRaca = new String[Raca.contarRacas()];
        int i = 0;
        for (Raca raca : lista) {
            listaRaca[i] = raca.getNome();
            i++;
        }
        return listaRaca;
    }

    
     private  void preencherTabela(){
        DefaultTableModel lista = (DefaultTableModel) jTableLista.getModel();
        try {
            ArrayList<Personagem> listaPersonagem = Personagem.listarPersonagem();
             while(lista.getRowCount() >0){
                lista.removeRow(0);
            }
            for(Personagem jogador : listaPersonagem){
            lista.addRow(new Object[]{
                jogador.getIdPersonagem(),
                jogador.getNome(),
                jogador.getRaca(),
                jogador.getClasse().get(0).getNome(),
                jogador.getNivel(),
                jogador.getAtributos().get(0).getValor(),
                jogador.getAtributos().get(1).getValor(),
                jogador.getAtributos().get(2).getValor(),
                jogador.getAtributos().get(3).getValor(),
                jogador.getAtributos().get(4).getValor(),
                jogador.getAtributos().get(5).getValor(),
                
            });
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaPersonagens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form MenuCard
     */
    public MenuCard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Root = new javax.swing.JPanel();
        try{
            Menu = new FundoBg(getClass().getResource( "/img/taverna.jpg" ).getFile());
        }catch(Exception e){
            Menu = new javax.swing.JPanel();
        };
        jPanelBotoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JButtonListar = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        try{
            Lista = new FundoBg(getClass().getResource( "/img/fundoTabela.jpg" ).getFile());
        }catch(Exception e){
            Lista = new javax.swing.JPanel();
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();
        try{
            NovoPersonagem = new FundoBg(getClass().getResource( "/img/fundoTabela.jpg" ).getFile());
        }catch(Exception e){
            NovoPersonagem = new javax.swing.JPanel();
            jLabelNome = new javax.swing.JLabel();
            jTextFieldNome = new javax.swing.JTextField();
            jLabelRaca = new javax.swing.JLabel();
            jComboBoxRacas = new javax.swing.JComboBox<>();
            jLabelClasse = new javax.swing.JLabel();
            jComboBoxClasses = new javax.swing.JComboBox<>();
            jLabelTendencia = new javax.swing.JLabel();
            jTextFieldTendencia = new javax.swing.JTextField();
            jPanelAtr = new javax.swing.JPanel();
            jLabelAtrFor = new javax.swing.JLabel();
            jLabelAtrDes = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jTextFieldAtrDes = new javax.swing.JTextField();
            jTextFieldAtrFor = new javax.swing.JTextField();
            jTextFieldAtrCon = new javax.swing.JTextField();
            jTextFieldAtrInt = new javax.swing.JTextField();
            jTextFieldAtrSab = new javax.swing.JTextField();
            jTextFieldAtrCar = new javax.swing.JTextField();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTextPaneDescricao = new javax.swing.JTextPane();
            jLabel2 = new javax.swing.JLabel();
            jButtonSalvar = new javax.swing.JButton();
            jButtonVoltar1 = new javax.swing.JButton();
            jLabelDivindade = new javax.swing.JLabel();
            jTextFieldDivindade = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            Root.setLayout(new java.awt.CardLayout());

            jPanelBotoes.setOpaque(false);
            jPanelBotoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            String texto = "0";
            try{
                texto = Personagem.contaPersonagem();
            }catch(Exception ek){}
            jLabel1.setFont(new java.awt.Font("Blackadder ITC", 0, 30)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(102, 255, 255));
            jLabel1.setText(texto + " fichas cadastradas");
            jPanelBotoes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

            JButtonListar.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
            JButtonListar.setText("Listar todos os Personagens");
            JButtonListar.setOpaque(false);
            JButtonListar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JButtonListarActionPerformed(evt);
                }
            });
            jPanelBotoes.add(JButtonListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 270, 30));

            jButtonCreate.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
            jButtonCreate.setText("Novo Personagem");
            jButtonCreate.setOpaque(false);
            jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonCreateActionPerformed(evt);
                }
            });
            jPanelBotoes.add(jButtonCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 270, 30));

            jPanelTitulo.setOpaque(false);

            jLabelTitulo.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
            jLabelTitulo.setForeground(new java.awt.Color(102, 255, 255));
            jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabelTitulo.setText("Projeto D&D RPG -- Gerenciador de Personagens");

            javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
            jPanelTitulo.setLayout(jPanelTituloLayout);
            jPanelTituloLayout.setHorizontalGroup(
                jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTituloLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE))
            );
            jPanelTituloLayout.setVerticalGroup(
                jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo))
            );

            javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
            Menu.setLayout(MenuLayout);
            MenuLayout.setHorizontalGroup(
                MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuLayout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(MenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            MenuLayout.setVerticalGroup(
                MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52))
            );

            Root.add(Menu, "Menu");

            jTableLista.setFont(new java.awt.Font("Vladimir Script", 0, 30)); // NOI18N
            jTableLista.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "#", "Nome", "Raça", "Classe", "nivel", "FOR", "DES", "CON", "INT", "SAB", "CAR"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jTableLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTableLista.setOpaque(false);
            jTableLista.setRowHeight(28);
            jTableLista.setSelectionForeground(new java.awt.Color(0, 0, 0));
            jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaselecao(evt);
                }
            });
            jScrollPane4.setViewportView(jTableLista);

            jButtonVoltar.setText("Voltar");
            jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonVoltarActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout ListaLayout = new javax.swing.GroupLayout(Lista);
            Lista.setLayout(ListaLayout);
            ListaLayout.setHorizontalGroup(
                ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListaLayout.createSequentialGroup()
                    .addGroup(ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ListaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonVoltar))
                        .addGroup(ListaLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)))
                    .addGap(59, 59, 59))
            );
            ListaLayout.setVerticalGroup(
                ListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(jButtonVoltar)
                    .addGap(21, 21, 21))
            );

            Root.add(Lista, "Lista");

        }

        jLabelNome.setFont(new java.awt.Font("Blackadder ITC", 3, 24)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(0, 204, 204));
        jLabelNome.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldNome.setToolTipText("");
        jTextFieldNome.setMinimumSize(new java.awt.Dimension(80, 20));
        jTextFieldNome.setName(""); // NOI18N
        jTextFieldNome.setPreferredSize(new java.awt.Dimension(80, 20));

        jLabelRaca.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelRaca.setForeground(new java.awt.Color(0, 204, 204));
        jLabelRaca.setText("Raça");
        jLabelRaca.setToolTipText("");

        try{
            jComboBoxRacas.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
            jComboBoxRacas.setModel(new javax.swing.DefaultComboBoxModel<>( listarRaca()));
        }catch(Exception e){}
        jComboBoxRacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRacasActionPerformed(evt);
            }
        });

        jLabelClasse.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelClasse.setForeground(new java.awt.Color(0, 204, 204));
        jLabelClasse.setText("Classe");

        try{
            jComboBoxClasses.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
            jComboBoxClasses.setModel(new javax.swing.DefaultComboBoxModel<>(listarClasses()));
        }catch(Exception e){}

        jLabelTendencia.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelTendencia.setForeground(new java.awt.Color(0, 204, 204));
        jLabelTendencia.setText("Tendencia");

        jTextFieldTendencia.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldTendencia.setPreferredSize(new java.awt.Dimension(50, 20));

        jPanelAtr.setOpaque(false);

        jLabelAtrFor.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelAtrFor.setForeground(new java.awt.Color(0, 204, 204));
        jLabelAtrFor.setText("Força");
        jLabelAtrFor.setToolTipText("");

        jLabelAtrDes.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelAtrDes.setForeground(new java.awt.Color(0, 204, 204));
        jLabelAtrDes.setText("Destreza");

        jLabel3.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Constituição");

        jLabel4.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Inteligencia");

        jLabel5.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("Sabedoria");

        jLabel6.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("Carisma");

        jTextFieldAtrDes.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrDes.setPreferredSize(new java.awt.Dimension(50, 20));

        jTextFieldAtrFor.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrFor.setPreferredSize(new java.awt.Dimension(50, 20));

        jTextFieldAtrCon.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrCon.setPreferredSize(new java.awt.Dimension(50, 20));

        jTextFieldAtrInt.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrInt.setPreferredSize(new java.awt.Dimension(50, 20));

        jTextFieldAtrSab.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrSab.setPreferredSize(new java.awt.Dimension(50, 20));

        jTextFieldAtrCar.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldAtrCar.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanelAtrLayout = new javax.swing.GroupLayout(jPanelAtr);
        jPanelAtr.setLayout(jPanelAtrLayout);
        jPanelAtrLayout.setHorizontalGroup(
            jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldAtrCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAtrFor)
                    .addComponent(jLabelAtrDes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldAtrDes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAtrFor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldAtrCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldAtrInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldAtrSab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelAtrLayout.setVerticalGroup(
            jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAtrFor)
                    .addComponent(jTextFieldAtrFor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAtrDes)
                    .addComponent(jTextFieldAtrDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAtrCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAtrInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldAtrSab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAtrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAtrCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextPaneDescricao.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextPaneDescricao);

        jLabel2.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Descrição do personagem");

        jButtonSalvar.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar1.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jButtonVoltar1.setText("Voltar");
        jButtonVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltar1ActionPerformed(evt);
            }
        });

        jLabelDivindade.setFont(new java.awt.Font("Blackadder ITC", 0, 24)); // NOI18N
        jLabelDivindade.setForeground(new java.awt.Color(0, 204, 204));
        jLabelDivindade.setText("Divindade");

        jTextFieldDivindade.setFont(new java.awt.Font("Blackadder ITC", 0, 18)); // NOI18N
        jTextFieldDivindade.setPreferredSize(new java.awt.Dimension(80, 20));

        javax.swing.GroupLayout NovoPersonagemLayout = new javax.swing.GroupLayout(NovoPersonagem);
        NovoPersonagem.setLayout(NovoPersonagemLayout);
        NovoPersonagemLayout.setHorizontalGroup(
            NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoPersonagemLayout.createSequentialGroup()
                .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NovoPersonagemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRaca))
                    .addComponent(jPanelAtr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(NovoPersonagemLayout.createSequentialGroup()
                        .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(NovoPersonagemLayout.createSequentialGroup()
                                .addComponent(jComboBoxRacas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelClasse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTendencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTendencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDivindade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDivindade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NovoPersonagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVoltar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar))
        );
        NovoPersonagemLayout.setVerticalGroup(
            NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoPersonagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRaca)
                    .addComponent(jComboBoxRacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClasse)
                    .addComponent(jComboBoxClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTendencia)
                    .addComponent(jTextFieldTendencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDivindade)
                    .addComponent(jTextFieldDivindade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NovoPersonagemLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelAtr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(NovoPersonagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonVoltar1))
                .addContainerGap())
        );

        Root.add(NovoPersonagem, "Novo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Root, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Root, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonListarActionPerformed

       CardLayout card = (CardLayout) Root.getLayout();
       card.show(Root, "Lista");
    }//GEN-LAST:event_JButtonListarActionPerformed

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed

        CardLayout card = (CardLayout) Root.getLayout();
       card.show(Root, "Novo");
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jTableListaselecao(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaselecao

        this.setVisible(false);
        EditarPersonagem personagem = null;
        try {
            int id = (int) jTableLista.getModel().getValueAt(jTableLista.getSelectedRow(), 0);
            System.out.println(id);
            personagem = new EditarPersonagem(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaPersonagens.class.getName()).log(Level.SEVERE, null, ex);
        }
        personagem.setVisible(true);
    }//GEN-LAST:event_jTableListaselecao

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        this.setVisible(false);
        new MenuPrincipal().setVisible(true);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxRacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRacasActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Personagem personagem = new Personagem();
        Atributos atr[] = new Atributos[6];
        Classe classe = new Classe();

        atr[0] = new Atributos();
        atr[1] = new Atributos();
        atr[2] = new Atributos();
        atr[3] = new Atributos();
        atr[4] = new Atributos();
        atr[5] = new Atributos();

        atr[0].setNome("Forca");
        atr[0].setValor(Integer.valueOf(jTextFieldAtrFor.getText()));
        atr[1].setNome("Destreza");
        atr[1].setValor(Integer.valueOf(jTextFieldAtrDes.getText()));
        atr[2].setNome("Constituicao");
        atr[2].setValor(Integer.valueOf(jTextFieldAtrCon.getText()));
        atr[3].setNome("Inteligencia");
        atr[3].setValor(Integer.valueOf(jTextFieldAtrInt.getText()));
        atr[4].setNome("Sabedoria");
        atr[4].setValor(Integer.valueOf(jTextFieldAtrSab.getText()));
        atr[5].setNome("Carisma");
        atr[5].setValor(Integer.valueOf(jTextFieldAtrCar.getText()));

        classe.setIdClasse((jComboBoxClasses.getSelectedIndex() + 1));

        personagem.setDescricao(jTextPaneDescricao.getText());
        personagem.setNome(jTextFieldNome.getText());
        personagem.setTendencia(jTextFieldTendencia.getText());
        personagem.setRaca(jComboBoxRacas.getSelectedItem().toString());
        personagem.setDivindade(jTextFieldDivindade.getText());

        try {
            personagem.setIdPersonagem(Personagem.getLastId() + 1);
            personagem.salvar();
            classe.salvar(personagem.getIdPersonagem());
            for (int i = 0; i < atr.length; i++) {
                atr[i].setIdAtributo(i+1);
                atr[i].salvar(personagem.getIdPersonagem());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.setVisible(false);
            new MenuPrincipal().setVisible(true);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltar1ActionPerformed
        this.setVisible(false);
        new MenuPrincipal().setVisible(true);

    }//GEN-LAST:event_jButtonVoltar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonListar;
    private javax.swing.JPanel Lista;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel NovoPersonagem;
    private javax.swing.JPanel Root;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JButton jButtonVoltar1;
    private javax.swing.JComboBox<String> jComboBoxClasses;
    private javax.swing.JComboBox<String> jComboBoxRacas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAtrDes;
    private javax.swing.JLabel jLabelAtrFor;
    private javax.swing.JLabel jLabelClasse;
    private javax.swing.JLabel jLabelDivindade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelRaca;
    private javax.swing.JLabel jLabelTendencia;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelAtr;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField jTextFieldAtrCar;
    private javax.swing.JTextField jTextFieldAtrCon;
    private javax.swing.JTextField jTextFieldAtrDes;
    private javax.swing.JTextField jTextFieldAtrFor;
    private javax.swing.JTextField jTextFieldAtrInt;
    private javax.swing.JTextField jTextFieldAtrSab;
    private javax.swing.JTextField jTextFieldDivindade;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTendencia;
    private javax.swing.JTextPane jTextPaneDescricao;
    // End of variables declaration//GEN-END:variables
}
