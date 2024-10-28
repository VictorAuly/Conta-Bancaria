package Visualização;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Modelo.Movimentacao;

public class EntradaSaida {
   public static String solicitaTitular(){
    String titular;
    titular = JOptionPane.showInputDialog("Qual é o nome do titular da conta?");
    return titular;
   }
   public static int solicitarTipoDeConta(){
    String[] tipoConta = {"Conta Poupança","Conta Corrente"};
    JComboBox<String> boxTipoConta = new JComboBox<>(tipoConta);
    //JOptionPane.showConfirmDialog(null, boxTipoConta,"Qual o seu tipo de conta", JOptionPane.OK_CANCEL_OPTION);
    boxTipoConta.setSelectedIndex(0);
                
       int resultado;
       do {
           resultado = JOptionPane.showConfirmDialog(null, boxTipoConta, 
                   "Bem vindo ao Banco Senai, selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

           if (resultado != JOptionPane.OK_OPTION) {
               JOptionPane.showMessageDialog(null, 
                       "Você deve selecionar uma das opções para continuar.", 
                       "Seleção Obrigatória", JOptionPane.WARNING_MESSAGE);
           }

       } while (resultado != JOptionPane.OK_OPTION); 
       return (int) boxTipoConta.getSelectedIndex();    
   }
   public static Double solicitaSaldo(){
    Double saldo;
    do{
    saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você tem de saldo na conta?")); 
      if (saldo <0) {
         JOptionPane.showMessageDialog(null, 
               "Você deve colocar um saldo maior ou igual a zero para continuar.", 
               "Seleção Obrigatória", JOptionPane.WARNING_MESSAGE);
      }
    }while(saldo <0);
    return saldo;
   }
   public static int solicitarOperacao(){
      String[] opcoes= {"Depositar","Sacar","Visualizar saldo da conta","Gerar extrato da conta",
      "Gerar extrato de depositos","Gerar extrato de saques","Ver dados da conta","Sair do programa"};
         JComboBox<String> boxMenu = new JComboBox<String>(opcoes);
         boxMenu.setSelectedIndex(0);
                
       int resultado;
       do {
           resultado = JOptionPane.showConfirmDialog(null, boxMenu, 
                   "Bem vindo ao Banco Senai, selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

           if (resultado != JOptionPane.OK_OPTION) {
               JOptionPane.showMessageDialog(null, 
                       "Você deve selecionar uma das opções para continuar.", 
                       "Seleção Obrigatória", JOptionPane.WARNING_MESSAGE);
           }

       } while (resultado != JOptionPane.OK_OPTION); 
       return (int) boxMenu.getSelectedIndex();
   }
   public static Double solicitarDeposito(){
      Double deposito;
    do{
      deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja depositar na conta?")); 
      if (deposito <0) {
         JOptionPane.showMessageDialog(null, 
               "Você deve colocar um saldo maior ou igual a zero para continuar.", 
               "Seleção Obrigatória", JOptionPane.WARNING_MESSAGE);
      }
    }while(deposito <0);
    return deposito;
   }
   public static Double solicitarSaque(){
      Double saque;
    do{
      saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Quanto você deseja retirar da conta?")); 
      if (saque <0) {
         JOptionPane.showMessageDialog(null, 
               "Você deve colocar um saldo maior ou igual a zero para continuar.", 
               "Seleção Obrigatória", JOptionPane.WARNING_MESSAGE);
      }
    }while(saque <0);
    return saque;
   }
   public static void exibirSaldo(Double getSaldo){
      JOptionPane.showMessageDialog(null, "Você tem: R$"+getSaldo);
   }
   public static void exibirExtratoDeDepositos(ArrayList<Movimentacao>historicoDepositos){
      StringBuilder extrato = new StringBuilder("Extrato de Depósitos: \n");
      if(historicoDepositos.isEmpty()){
         extrato.append("Nenhumm depósito foi realizado!");
      }else{
         for(Movimentacao movimentacao : historicoDepositos){
            extrato.append("Depósito de R$").append(movimentacao.getValor()).append(" em ")
            .append(movimentacao.getData()).append("\n");
         }
      }
      JOptionPane.showMessageDialog(null,extrato.toString());
   }
   public static void exibirExtratoSaques(ArrayList<Movimentacao>historicoSaques){
      StringBuilder extrato = new StringBuilder("Extrato de Saques: \n");
      if(historicoSaques.isEmpty()){
         extrato.append("Nenhumm saque foi realizado!");
      }else{
         for(Movimentacao movimentacao : historicoSaques){
            extrato.append("Saque de R$").append(movimentacao.getValor()).append(" em ")
            .append(movimentacao.getData()).append("\n");
         }
      }
      JOptionPane.showMessageDialog(null,extrato.toString());
   }
   public static void exibiMsgEncerraPrograma(){
      JOptionPane.showMessageDialog(null,"O programa será encerrado!");
  }
   public static void exibirDadosDaConta(String titular, int tipoConta, Double saldo) {
   String StringtipoConta;

   if (tipoConta == 0) {
      StringtipoConta = "Conta Poupança";
   } else{
      StringtipoConta = "Conta Corrente";
   }
   StringBuilder dadosConta = new StringBuilder();
   dadosConta.append("Dados da Conta:\n")
             .append("Titular: ").append(titular).append("\n")
             .append("Tipo de Conta: ").append(StringtipoConta).append("\n")
             .append("Saldo Atual: R$ ").append(saldo).append("\n");

   JOptionPane.showMessageDialog(null, dadosConta.toString(), "Informações da Conta", JOptionPane.INFORMATION_MESSAGE);
}
   public static void exibirExtratoCompleto(ArrayList<Movimentacao> historicoDepositos, ArrayList<Movimentacao> historicoSaques) {
      StringBuilder extratoGeral = new StringBuilder("Extrato geral da Conta: \n");
      
      if (historicoDepositos.isEmpty() && historicoSaques.isEmpty()) {
          extratoGeral.append("Não ocorreu nenhum depósito ou saque nesta conta!");
      } else {
          if (!historicoDepositos.isEmpty()) {
              extratoGeral.append("\n--- Depósitos ---\n");
              for (Movimentacao movimentacao : historicoDepositos) {
                  extratoGeral.append("Depósito de R$").append(movimentacao.getValor())
                              .append(" em ").append(movimentacao.getData()).append("\n");
              }
          } else {
              extratoGeral.append("\nNenhum depósito foi realizado.\n");
          }
  
          if (!historicoSaques.isEmpty()) {
              extratoGeral.append("\n--- Saques ---\n");
              for (Movimentacao movimentacao : historicoSaques) {
                  extratoGeral.append("Saque de R$").append(movimentacao.getValor())
                              .append(" em ").append(movimentacao.getData()).append("\n");
              }
          } else {
              extratoGeral.append("\nNenhum saque foi realizado.\n");
          }
      }
  
      JOptionPane.showMessageDialog(null, extratoGeral.toString());
  }  
}
