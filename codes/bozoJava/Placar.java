package ex3;

public class Placar {

    private int size = 11; // tamanho do placar

    private int[] val_pos;

    public Placar() {  
        for(int i=0; i<size; i++) 
            val_pos = new int[i];
    }

    public void add(int posicao, int[] dados) {
        if(posicao > 0 && posicao < 7) { // posicao externa
            int sum = 0;
            for(int i=0; i<dados.length; i++) {
                if(dados[i] == posicao) sum += dados[i];
            }
            val_pos[posicao-1] = sum; 
        }
        
        int tam_dado = 6;
        int[] b = new int[tam_dado]; // dados de 6 lados
        // obtendo numero de dados indexado por valor
        for(int i=0; i<dados.length; i++) {
            b[dados[i]-1] += 1;
        }
        boolean flag5 = false;
        boolean flag4 = false;
        boolean flag3 = false;
        boolean flag2 = false;
        for(int i=0; i<tam_dado; i++) {
            if(b[i] >= 5) // cinco iguais
                flag5 = true;
            if(b[i] >= 4) // quatro iguais
                flag4 = true;
            if(b[i] >= 3) // tres iguais
                flag3 = true;
            else if(b[i] >= 2) // dois iguais
                flag2 = true;
        }

        // posicao interna
        if(posicao==7) {
            // full hand
            if(flag2 && flag3) val_pos[posicao-1] = 15;
            if(flag5) val_pos[posicao-1] = 15;
        }
        else if(posicao==8) {
            // sequencia
            int sum = 0;
            for(int i=0; i<tam_dado; i++) {
                if(b[i] >= 1) sum ++;
            }
            if(sum >= dados.length) val_pos[posicao-1] = 20;
        }
        else if(posicao==9) { // quadra
            if(flag4) val_pos[posicao-1] = 30;
        }
        else if(posicao==10) { // quina
            if(flag5) val_pos[posicao-1] = 40;
        }
    }

    public int getScore() {
        // soma os valores
        int sum = 0;
        for(int i=0; i<size-1; i++) {
            sum += val_pos[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        String r = new String();
        int left = 1;
        int mid = 7;
        int right = 4;
        for(int i=0; i<3; i++) {
            // add left
            if(val_pos[left-1] != 0) r = r + ' ' + val_pos[left-1];
            else r = r + "(" + left + ")";
            r = r + "   |   ";
            // add mid
            if(val_pos[mid-1] != 0) r = r + ' ' + val_pos[mid-1];
            else r = r + "(" + mid + ")";
            r = r + "   |   ";
            // add right
            if(val_pos[right-1] != 0) r = r + ' ' + val_pos[right-1];
            else r = r + "(" + right + ")";
            r = r + "   |\n";
            // add delimiter
            r = r + "--------------------------\n";
            left++; right++; mid++;
        }
        r = r + "      |   ";
        if(val_pos[9] != 0) r = r + val_pos[9] + "   |\n";
        else r = r + "(10)" + "   |\n";
        r = r + "      +----------+\n";

        return r;
    }
}
