import poker
from poker import Poker

poker = Poker()
poker.roundInicial()
poker.printJogo()
while(poker.temGrana()):
    valores = str(input("digite as cartas que voce quer trocar: "))
    bool = poker.trocaCartas(valores)
    
    poker.printJogo() 
    poker.avaliaJogo()
    
    if(not bool): #acaba o jogo
        break