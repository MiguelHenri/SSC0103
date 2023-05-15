from baralho import Carta
from baralho import Baralho

class Poker: 
    def __init__(self):
        self.baralho = Baralho()
        self.jogo = []
        self.grana = 200

    def roundInicial(self):
        self.baralho.embaralha()
        for i in range(5):
            self.jogo.append(self.baralho.tiraCarta())

    def trocaCartas(self, valores):
        if not valores: # exige diferente de string nula
            return False

        self.baralho.embaralha() 
        # separando as cartas a serem trocadas
        trocas = [int(valor) for valor in valores.split(' ')]
        for troca in trocas:
            if troca > 0 and troca < 6:
                # trocando as cartas
                c = self.jogo[troca - 1]
                self.jogo[troca - 1] = self.baralho.tiraCarta()
                self.baralho.devolveCarta(c)
                self.baralho.embaralha() # embaralhando
        return True

    def printJogo(self):
        for carta in self.jogo:
            print(carta.getVal() + carta.getNaipe())

    def temGrana(self):
        return self.grana > 0
    
    def avaliaJogo(self):
        numeros = []
        naipes = []
        mapNum = [0] * 13 #mapping a quantidade de cada carta
        mapNaipe = [0] * 4 #mapping com a quantidade de cada naipe
        for carta in self.jogo:
            numeros.append(carta.getNum())
            naipes.append(carta.getNaipeNum())
        #obtendo quantas cartas temos de cada valor e naipe
        for num in numeros:
            mapNum[num] += 1
        for naipe in naipes:
            mapNaipe[naipe] += 1
        #avaliando o jogo
        flush = 0
        sequencia = 0
        pares = 0
        tripla = 0
        quadra = 0
        #verificando flush
        for np in mapNaipe:
            if np == 5: #cinco do mesmo naipe
                flush = 1
        #verificando quantidade de cartas
        for n in mapNum:
            if n == 2:
                pares += 1
            if n == 3:
                tripla += 1
            if n == 4:
                quadra += 1
            if n == 1:
                sequencia += 1
            else: 
                if sequencia != 5:
                    sequencia = 0
        #atualizando o dinheiro
        #royal straigth flush
        if sequencia and flush and mapNum[12] == 1:
            self.grana += 1
        #straigth flush
        if sequencia and flush and mapNum[12] == 0:
            self.grana += 1
        #sequencia
        if sequencia and not flush:
            self.grana += 1
        #flush
        if flush and not sequencia:
            self.grana += 1
        #dois pares
        if pares == 2:
            self.grana += 1
        #full house
        if tripla and pares == 1:
            self.grana += 1
        #tripla
        if tripla and pares == 0:
            self.grana += 1
        #quadra
        if quadra:
            self.grana += 1
