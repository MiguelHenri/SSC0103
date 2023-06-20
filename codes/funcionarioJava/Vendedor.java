package ex6;

public class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, String cpf, double comissao) {
        super(nome, cpf);
        this.comissao = comissao;
    }

    public double calculaSalario() {
        return salarioBase + comissao;
    }
}