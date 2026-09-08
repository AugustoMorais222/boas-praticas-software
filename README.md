# boas-praticas-software

Atividade prática da disciplina **Manutenção e Configuração de Software**
(Normas de Configuração, Boas Práticas e Git).

O sistema calcula a média das notas de um aluno e informa se ele foi aprovado
ou reprovado.

## Estrutura

```
src/
├── Aluno.java     # dados do aluno, cálculo da média e verificação da situação
└── Sistema.java   # ponto de entrada e apresentação do boletim
```

## Como executar

```bash
javac -d out src/*.java
java -cp out Sistema
```

Saída esperada:

```
Aluno: Carlos
Media: 7.5
Aprovado
```

## Histórico de versões

| Branch                    | Conteúdo                                          |
| ------------------------- | ------------------------------------------------- |
| `main`                    | versão original recebida e, após o merge, a final |
| `melhoria-boas-praticas`  | aplicação das boas práticas                       |

---

## Questão final

### 1. Qual era o principal problema do código original?

O principal problema era a **falta de legibilidade**. Todo o programa estava
concentrado dentro do método `main`, misturando em um único bloco a entrada dos
dados, o cálculo da média, a regra de aprovação e a exibição dos resultados.

Somado a isso, os nomes das variáveis (`n`, `a`, `b`, `c`) não comunicavam nada:
era preciso ler a linha do cálculo para descobrir que `c` era a média e que `a` e
`b` eram notas. Havia ainda o número mágico `6` na condição do `if`, sem indicar
que se tratava da média mínima para aprovação. O código funcionava, mas qualquer
manutenção exigiria reinterpretá-lo por inteiro.

### 2. Quais melhorias você realizou?

- **Nomes descritivos:** `n` virou `nome`, `a` e `b` viraram
  `notaPrimeiroBimestre` e `notaSegundoBimestre`, e `c` virou `media`.
- **Modularização:** criei a classe `Aluno`, responsável por guardar os dados e
  responder `calcularMedia()`, `estaAprovado()` e `obterSituacao()`. A classe
  `Sistema` ficou apenas com o ponto de entrada e o método `exibirBoletim()`.
- **Eliminação do número mágico:** o valor `6` passou a ser a constante
  `MEDIA_MINIMA_PARA_APROVACAO`, que explica seu próprio significado e concentra
  a regra em um único ponto.
- **Código auto comentado:** os nomes de métodos e variáveis explicam o que o
  código faz, então os comentários se limitam a uma breve descrição do papel de
  cada classe.
- **Padronização:** `PascalCase` para classes, `camelCase` para métodos e
  variáveis, `UPPER_SNAKE_CASE` para constantes, indentação de 4 espaços e
  arquivos-fonte organizados na pasta `src/`, uma classe por arquivo.

O comportamento do programa não mudou: a saída continua exatamente a mesma da
versão original.

### 3. Como a modularização facilitou a organização do código?

Cada parte do sistema passou a ter uma responsabilidade única e um lugar óbvio
para ser encontrada. Para mudar a nota de corte, mexo apenas na constante de
`Aluno`; para mudar o formato do boletim, mexo apenas em `exibirBoletim()`. Antes,
qualquer uma dessas mudanças significava editar o mesmo `main` sobrecarregado,
com risco de afetar sem querer outra parte do programa.

A modularização também tornou o código mais fácil de ler e de estender: o `main`
agora se lê quase como uma descrição do que o sistema faz, e a lógica de negócio
ficou isolada da apresentação, podendo ser reaproveitada ou testada
separadamente.

### 4. Como o Git ajudou a controlar as alterações realizadas no sistema?

O Git preservou o código original em um commit próprio, então a versão de partida
nunca foi perdida — é possível compará-la com a versão melhorada (`git diff`) ou
voltar a ela a qualquer momento.

As melhorias foram feitas na branch `melhoria-boas-praticas`, isolada da `main`,
o que permitiu trabalhar sem quebrar a versão estável. As mensagens de commit
registram *o que* mudou e *por quê*, servindo de documentação do raciocínio. Por
fim, o Pull Request criou um momento explícito de revisão antes de o código
entrar na `main`, e o merge integrou as mudanças mantendo todo o histórico
rastreável.
