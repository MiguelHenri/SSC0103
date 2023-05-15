import random

class Carta:

    def __init__(self):
        self.val = ""
        self.num = -1
        self.naipe = ""
        self.npNum = -1

    def setValString(self, n):
        if n >= 0 and n < 9:
            self.val = str(n+2)
        if n == 9:
            self.val = "J"
        if n == 10:
            self.val = "Q"
        if n == 11:
            self.val = "K"
        if n == 12:
            self.val = "A"
        self.num = n
        
    def setNaipeString(self, n):
        if n == 0:
            self.naipe = "\u2663" #paus
        if n == 1:
            self.naipe = "\u2665" #copas
        if n == 2:
            self.naipe = "\u2666" #ouros
        if n == 3:
            self.naipe = "\u2660" #espadas
        self.npNum = n

    def getVal(self):
        return self.val
    
    def getNaipe(self):
        return self.naipe
    
    def getNum(self):
        return self.num
    
    def getNaipeNum(self):
        return self.npNum

class Baralho:

    def __init__(self):
        self.cartas = []
        for i in range(4):
            for j in range(13): #13 valores
                carta = Carta()
                carta.setValString(j)
                carta.setNaipeString(i)
                self.cartas.append(carta)

    def embaralha(self):
        random.shuffle(self.cartas)

    def tiraCarta(self):
        return self.cartas.pop()
    
    def devolveCarta(self, c):
        self.cartas.append(c)

    def printBaralho(self):
        for carta in self.cartas:
            print(carta.getVal() + carta.getNaipe())