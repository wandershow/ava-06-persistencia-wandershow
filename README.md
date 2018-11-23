# Persistência

_Classroom link:_ <https://classroom.github.com/a/>

[There are more databases in the cloud and the earth, Horatio, Than are dreamt of in your philosophy](https://www.youtube.com/watch?v=bSAc56YCOaE)

## Implementar modelo, DAO e escrever testes

#### Assuntos

- supertipagem
- generalização
- abstração
- persistência
- bancos de dados

#### Prazo: 2018-12-02 Peso: 1.5 pt

**Regras**

* A biblioteca padrão (API) do Java está liberada;
* É recomendado o uso da IDE Eclipse, mas não obrigatório. Caso utilizada, apenas o conteúdo da pasta `src` deve ser _upado_, não enviar o projeto ou _workspace_ inteiro;
* Prazo até 02 de dezembro, domingo, com _permission granted to **burn the midnight oil**_.

### Persistência de `professor` (0.7 pts)

Criar uma tabela, _model_ e DAO para persistir dados de professores. Use o exemplo de aluno (pastas `src` e arquivo `schema.sql`) para fazê-lo.

Deve ter atributos variados, `int`, `enum`, `String`, por exemplo. Não é necessário ter relacionamentos, chaves compostas, se está avaliando POO.

Escreva testes.

### DAO abstrato (0.8)

Elabore uma classe abstrata, `AbstractModel` ou outro nome, e faça com que os _model's_ concretos (`Aluno` e `Professor`) o estendam. Implemente no _model_ abstrato tudo o que for redundante e reaproveitável.

Elabore uma classe abstrata, `AbstractDAO` ou outro nome, e faça com que os DAOs concretos (`AlunoDAO` e `ProfessorDAO`) o estendam. Implemente no DAO abstrato tudo que for redundante dos DAOs concretos e que possa ser aproveitado.

Escreva testes.

Desafio: é possível escrever o método `delete(int id):void` inteiramente no DAO abstrato, basta perceber o detalhe que muda nos DAOs concretos.

* * *

> _"The good news about computers is that they do what you tell them to do. The bad news is that they do what you tell them to do."
>
> -- Ted Nelson <https://twitter.com/CodeWisdom/status/1062338544876875777>
