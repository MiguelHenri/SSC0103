package ex6;

public class Assistente extends Funcionario {

    public Assistente(String nome, String cpf) {
        super(nome, cpf);
    }

    public double calculaSalario() {
        return salarioBase;
    }
}
