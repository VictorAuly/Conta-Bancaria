package Modelo;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Conta {
    private String titularDaConta;
    private int tipoConta;
    private Double saldo;
    private ArrayList<Movimentacao>historicoDepositos = new ArrayList<>();
    private ArrayList<Movimentacao>historicoSaques = new ArrayList<>();

   public Double getSaldo() {
       return saldo;
   }
   public void setSaldo(Double saldo) {
       this.saldo = saldo;
   }
   public int getTipoConta() {
       return tipoConta;
   }
   public void setTipoConta(int tipoConta) {
       this.tipoConta = tipoConta;
   }
   public String getTitularDaConta() {
       return titularDaConta;
   }
   public void setTitularDaConta(String titularDaConta) {
       this.titularDaConta = titularDaConta;
   }
   public ArrayList<Movimentacao> getHistoricoDepositos() {
       return historicoDepositos;
   }
   public ArrayList<Movimentacao> getHistoricoSaques() {
       return historicoSaques;
   }
   public void depositos(Double deposito){
    saldo+=deposito;
    Movimentacao movimentacao = new Movimentacao();
    movimentacao.setTipo(2);
    movimentacao.setValor(deposito);;
    movimentacao.setData(new Date());
    historicoDepositos.add(movimentacao);
   }
   public void saques(Double saques){
    saldo-=saques;
    if (saldo - saques < -1000) {
        JOptionPane.showMessageDialog(null, 
            "Saque não permitido! O saldo não pode ficar abaixo de -R$1000.",
            "Erro de Saque", JOptionPane.ERROR_MESSAGE);
            saldo += saques;
        return;
        
    }
    Movimentacao movimentacao = new Movimentacao();
    movimentacao.setTipo(1);
    movimentacao.setValor(saques);
    movimentacao.setData(new Date());
    historicoSaques.add(movimentacao);
   }
}
