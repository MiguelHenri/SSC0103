import funcionario as f

class Vendedor(f.Funcionario):
    def __init__(self, nome, cpf, comissao):
        super().__init__(nome, cpf)
        self.comissao = comissao

    def calculaSalario(self):
        return self.salarioBase + self.comissao

