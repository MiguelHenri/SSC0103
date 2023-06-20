import funcionario as f

class Assistente(f.Funcionario):
    def __init__(self, nome, cpf):
        super().__init__(nome, cpf)

    def calculaSalario(self):
        return self.salarioBase