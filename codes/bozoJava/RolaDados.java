package ex3;
import java.util.StringTokenizer;

public class RolaDados {
    
    private int num_dados = 0;

    private Dado[] dados;

    public RolaDados(int n) {
        // cria n dados
        dados = new Dado[n];
        for(int i=0; i<n; i++) {
            dados[i] = new Dado();
        }
        num_dados = n;
    }

    public int[] rolar() {
        // rolando num_dados dados
        int[] r = new int[num_dados];
        for(int i=0; i<num_dados; i++) {
            r[i] = dados[i].rolar();
        }
        return r; // vetor de valores 
    }

    public int[] rolar(boolean[] quais) {
        // rolando os dados do vetor de boolean
        int[] r = new int[num_dados];
        for(int i=0; i<num_dados; i++) {
            if(quais[i])
                r[i] = dados[i].rolar();
            else
                r[i] = dados[i].getLado();
        }
        return r;
    }

    public int[] rolar(String s) {
        // rolando os dados da string s
        int[] r = new int[num_dados];
        for(int i=0; i<num_dados; i++)
            r[i] = dados[i].getLado();
        // separando os valores
        StringTokenizer st = new StringTokenizer(s, " ", false);
        while(st.hasMoreTokens()) {
            String temp = new String();
            temp = st.nextToken();
            int dado = Integer.parseInt(temp);
            if(dado > num_dados) return r; // fora do range
            r[dado-1] = dados[dado-1].rolar();
        }
        return r;
    }

    @Override
    public String toString() {
        // exige que exista dados
        if (num_dados == 0) return "NULO";

        // pegando todas strings dos dados
        String[] s = new String[num_dados];
        for(int i=0; i<num_dados; i++) {
            s[i] = new String(dados[i].toString());
        }

        // tratando a informacao
        String r = new String();
        for(int i=1; i<=num_dados; i++) {
            r = r + "    " + i + "    ";
        }
        r = r + '\n';
        for(int k=0; k<s[0].length(); k+=8) {
            for(int i=0; i<num_dados; i++) {
                r = r + s[i].substring(0+k, 7+k) + "   ";
            }
            if(k+8 < s[0].length()) r = r + '\n';
        }

        return r;
    }
}
