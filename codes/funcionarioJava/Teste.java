package ex6;

import java.util.ArrayList;
import java.util.List;

// rodado usando vscode com extensao de java e terminal wsl
// classes em uma mesma pasta 'ex6'

public class Teste {

    // main
    public static void main(String[] args) {

        // criando funcionarios
        List<Funcionario> f = new ArrayList<>();
        f.add(new Gerente("Miguel", "23783941016"));
        f.add(new Gerente("Paulo", "39072559096"));
        f.add(new Assistente("Leonardo", "89926764096"));
        f.add(new Assistente("Gustavo", "28833073009"));
        f.add(new Assistente("Maria", "23783941020"));
        f.add(new Vendedor("Thais", "39072559021", 100));
        f.add(new Vendedor("Bia", "89926764022", 200));
        f.add(new Vendedor("Julia", "28833073023", 300));

        int sum = 0;
        // loop no array de funcionarios
        for (Funcionario func : f) {
            sum += func.calculaSalario();
            // testando cpfs
            if (!Funcionario.verificaCPF(func.getCPF())) {
                System.out.println(func.getNome() + " tem um CPF inválido.");
            }
        }

        // printa a soma dos salarios
        System.out.println("Valor total dos salários: " + sum + " reais.");
    }
}