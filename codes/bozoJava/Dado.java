package ex3;

public class Dado {
    private int lados = 0;
    private int valor_atual = 0;
    // chave random estatica para nao viciar o(s) dado(s)
    static private Random rd = new Random(); 
    
    public Dado() {
        // cria um dado padrao (6 lados)
        lados = 6;
    }

    public Dado(int n) {
        // cria um dado de n lados
        lados = n;
    }

    public int getLado() {
        // retorna o valor atual do dado
        return valor_atual;
    }

    public int rolar() {
        // retorna o valor obtido ao rolar o dado
        // gerando numero aleatorio entre 1 e numero de lados
        valor_atual = rd.getIntRand(lados) + 1;
        return valor_atual;
    }

    @Override
    public String toString() {
        // exige que seja um dado de 6 lados
        String delimitador = new String("+-----+");
        String dado = new String("\n|     |\n|     |\n|     |\n");

        // excecao, retorna dado vazio
        if(lados > 6 || lados == 0 || valor_atual == 0) return delimitador + dado + delimitador;

        // retorna um dado de 6 lados como string
        switch(valor_atual) {
            case 1:
                dado = "\n|     |\n|  *  |\n|     |\n";
                break;
            case 2:
                dado = "\n|*    |\n|     |\n|    *|\n";
                break;
            case 3:
                dado = "\n|*    |\n|  *  |\n|    *|\n";
                break;
            case 4:
                dado = "\n|*   *|\n|     |\n|*   *|\n";
                break;
            case 5: 
                dado = "\n|*   *|\n|  *  |\n|*   *|\n";
                break;
            case 6:
                dado = "\n|*   *|\n|*   *|\n|*   *|\n";
                break;
            default:
                break;
        }

        return delimitador + dado + delimitador;
    }
}
