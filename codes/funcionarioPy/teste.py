import gerente
import assistente
import vendedor

class Teste:

    @staticmethod
    def main():
        # listas de valores
        nomes = ["Miguel", "Paulo", "Leonardo", "Gustavo", "Maria", "Thais", "Bia", "Julia"]
        cpfVerdadeiro = ["23783941016", "39072559096", "89926764096", "28833073009"]
        cpfFalso = ["23783941020", "39072559021", "89926764022", "28833073023"]
        comissoes = [100, 200, 300]

        # criando funcionarios
        f = []
        f.append(gerente.Gerente(nomes[0], cpfVerdadeiro[0]))
        f.append(gerente.Gerente(nomes[1], cpfVerdadeiro[1]))
        f.append(assistente.Assistente(nomes[2], cpfVerdadeiro[2]))
        f.append(assistente.Assistente(nomes[3], cpfVerdadeiro[3]))
        f.append(assistente.Assistente(nomes[4], cpfFalso[0]))
        f.append(vendedor.Vendedor(nomes[5], cpfFalso[1], comissoes[0]))
        f.append(vendedor.Vendedor(nomes[6], cpfFalso[2], comissoes[1]))
        f.append(vendedor.Vendedor(nomes[7], cpfFalso[3], comissoes[2]))

        sum = 0
        # loop no array de funcionarios
        for func in f:
            sum += func.calculaSalario()
            # testando cpfs
            if (not func.verificaCPF(func.getCPF())):
                print(func.getNome() + " tem um CPF inválido.")

        # printa a soma dos salarios
        print("Valor total dos salários: " + str(sum) + " reais.")

# rodando a main
rodar = Teste()
rodar.main()
       

