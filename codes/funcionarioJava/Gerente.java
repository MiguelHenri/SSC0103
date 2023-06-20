package ex6;

public class Gerente extends Funcionario {
    
    public Gerente(String nome, String cpf) {
        super(nome, cpf);
    }

    public double calculaSalario() {
        return salarioBase * 2;
    }
}