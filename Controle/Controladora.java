package Controle;
import javax.swing.JOptionPane;
import Modelo.Conta;
import Visualização.EntradaSaida;

public class Controladora {

  public Conta iniciaConta() {
    
    JOptionPane.showMessageDialog(null, "Vamos criar uma conta!");
    Conta conta = new Conta();
    conta.setTitularDaConta(EntradaSaida.solicitaTitular()); 
    conta.setTipoConta(EntradaSaida.solicitarTipoDeConta());
    conta.setSaldo(EntradaSaida.solicitaSaldo());
    return conta;
  }
  public void exibirMenu(Conta conta){  
     int opcao;
     do{
      opcao = EntradaSaida.solicitarOperacao();
      Double valor = 0.0;
      switch (opcao) {
        case 0:
          valor = EntradaSaida.solicitarDeposito();
          conta.depositos(valor);
            break;  
        case 1:
          valor = EntradaSaida.solicitarSaque();
          conta.saques(valor);
            break;
        case 2:
          EntradaSaida.exibirSaldo(conta.getSaldo());
            break;
        case 3:
          EntradaSaida.exibirExtratoCompleto(conta.getHistoricoDepositos(),conta.getHistoricoSaques());
            break;
        case 4:
          EntradaSaida.exibirExtratoDeDepositos(conta.getHistoricoDepositos());
            break;
        case 5:
          EntradaSaida.exibirExtratoSaques(conta.getHistoricoSaques());
            break;
        case 6:
          EntradaSaida.exibirDadosDaConta(conta.getTitularDaConta(),conta.getTipoConta(),conta.getSaldo());
            break;
      }
     }while(opcao!=7);
     EntradaSaida.exibiMsgEncerraPrograma();
            System.exit(0);
  }   
}
