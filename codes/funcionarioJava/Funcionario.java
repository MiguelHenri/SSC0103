package ex6;

public abstract class Funcionario {
    // classe abstrata
    private String nome = "";
    private String CPF = "";
    public double salarioBase = 0;
    
    // construtor
    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.CPF = cpf;
        // hard coded salarioBase
        this.salarioBase = 1000;
    }

    // metodo abstrato
    public abstract double calculaSalario();

    // metodo estatico
    public static boolean verificaCPF(String cpf) {
        if (cpf == "00000000000") return false;
        
        int soma = 0;
        
        for(int i=1; i<=9; i++)
            soma = soma + Integer.parseInt(cpf.substring(i-1, i)) * (11 - i);
    
        int resto = (soma * 10) % 11;

        if ((resto == 10) || (resto == 11)) resto = 0;

        if (resto != Integer.parseInt(cpf.substring(9, 10))) return false;
        
        soma = 0;
        for(int i=1; i<=10; i++) 
            soma = soma + Integer.parseInt(cpf.substring(i-1, i)) * (12 - i);

        resto = (soma * 10) % 11;

        if ((resto == 10) || (resto == 11))
            resto = 0;

        if (resto != Integer.parseInt(cpf.substring(10, 11)))
            return false;
            
        return true;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getCPF() {
        return this.CPF;
    }

}
