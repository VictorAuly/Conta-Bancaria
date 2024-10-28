package Modelo;
import java.util.Date;

public class Movimentacao {
    private int tipoDeOperacao;
    private Double valor;
    private Date data;

    public int getTipo() {
        return tipoDeOperacao;
    }
    public void setTipo(int tipoDeOperacao) {
        this.tipoDeOperacao = tipoDeOperacao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}
