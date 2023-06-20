# classe pai
from abc import ABCMeta, abstractmethod

class Funcionario:

    # classe abstrata
    __metaclass__ = ABCMeta

    def __init__(self, nome, cpf):
        self.nome = nome
        self.CPF = cpf
        # salario base hard coded
        self.salarioBase = 1000

    @abstractmethod
    def calculaSalario(self):
        pass

    @staticmethod
    def verificaCPF(cpf):
        if (cpf == "00000000000"):
            return False
        
        soma = 0
        
        for i in range(9):
            i += 1 
            soma = soma + int(cpf[i-1:i]) * (11 - i)
    
        resto = (soma * 10) % 11

        if ((resto == 10) or (resto == 11)):
            resto = 0

        if (resto != int(cpf[9:10])):
            return False
        
        soma = 0
        for i in range(10):
            i += 1
            soma = soma + int(cpf[i-1:i]) * (12 - i)

        resto = (soma * 10) % 11

        if ((resto == 10) or (resto == 11)):
            resto = 0

        if (resto != int(cpf[10:11])):
            return False
            
        return True
    
    def getNome(self):
        return self.nome
    
    def getCPF(self):
        return self.CPF