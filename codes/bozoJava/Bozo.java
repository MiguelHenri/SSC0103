package ex3;
// rodei o programa utilizando o terminal com extensao de java do vscode
// todos os .java estavam dentro de uma pasta 'ex3'

public class Bozo {

    public Bozo() { }
    
    // runs Bozo game
    public static void main(String args[]) throws java.io.IOException {
        
        // criando novos dados de seis lados
        int num_dados = 5;
        RolaDados d = new RolaDados(num_dados); // Bozó usa cinco dados

        // criando placar
        Placar p = new Placar();

        // numero de rodadas
        int rodadas = 10;

        // valor dos dados
        int[] val_dados = new int[num_dados];

        // loop do jogo
        for(int i=1; i<=rodadas; i++) {
            
            // printa a rodada
            System.out.println("*********Rodada " + i);

            // rolando dados
            for(int j=0; j<3; j++) {
                if(j==0) { // primeira rodada
                    System.out.println("Pressione ENTER para lancar os dados.");
                    EntradaTeclado.leString();
                    val_dados = d.rolar();
                }
                else {
                    System.out.println("Digite o numero dos dados que quiser TROCAR. Separados por espacos.");
                    String s = EntradaTeclado.leString();
                    if(s.isEmpty()) break;
                    val_dados = d.rolar(s);
                }
                System.out.println(d.toString());
            }

            // printa o placar
            System.out.print(p.toString());
            
            // lendo jogada
            System.out.print("Escolha a posicao que quer ocupar com essa jogada ==>");
            p.add(EntradaTeclado.leInt(), val_dados);

            // printa o placar
            System.out.print(p.toString());
        }

        System.out.println("**************************\n" + 
        "*** Voce fez " + p.getScore() + " pontos!\n" + 
        "**************************\n");

    }

}