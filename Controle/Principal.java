package Controle;

public class Principal {
    public static void main(String[] args) {
        Controladora controladora = new Controladora();
        
        controladora.exibirMenu(controladora.iniciaConta());
    }
}
