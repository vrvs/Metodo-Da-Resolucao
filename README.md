# Método da Resolução

Projeto 2 da cadeira de Lógica para Computação (IF673)

## Projeto II - Gerador de Tabela-Verdade

O Projeto é um programa que aplica o Método da Resolução em Expressões bem-formadas. Para tal, haverá a necessidade que seu programa verifique se a expressão de entrada está na FNC e se todas as cláusulas são de Horn. É garantido que as expressões serão bem-formadas.
O programa poderá ser feito nas linguagens Python, C, C++ ou Java.

O programa deve ser entregue compilando, portanto, antes de enviar teste-o nas máquinas do CIn.

O projeto deve ser entregue em uma única classe com o nome "Resolucao.xx" (onde xx corresponde à linguagem que você usará) por e-mail para o seu monitor, com o assunto:
[Resolucao] - login  (onde login corresponde ao login do aluno no CIn).

Este exercício é individual. Qualquer tentativa de fraude ou cópia será punida com uma nota 0 (ZERO) para ambos os infratores.

## Detalhes

■ Quanto aos operadores:

Operador Lógico | Caracter Utilizado
--- | ---
OU | +
E | .
IMPLICAÇÃO | >
NEGAÇÃO | -

Só serão utilizados os operadores acima.

■ Quanto às variáveis:

Só serão utilizadas 4 (quatro) variáveis e, na saída, elas deverão aparecer estritamente nesta ordem:

```
a b c d
```
■ Quanto aos parênteses:


Operador Unário | Operador Binário
--- | ---
-a | (a>b)
-(a+b) | (a>("subexpressão"))
(-a+-y) | ("sub1"."sub2")

É garantido que todas as cláusulas serão cercadas por parênteses, mesmo que ela seja apenas um literal.



■ Quanto à Entrada/Saída

Nome do arquivo: "Resolucao.xx" 

Entrada: Nome do arquivo "Expressoes.in"

Contem várias expressões que serão avaliadas.
A 1ª linha da entrada será um número n, indicando quantas expressões precisarão ter suas entradas avaliadas. Logo a seguir teremos n linhas, onde cada uma possuirá uma expressão, sem espaçamento, que será a expressão a ser avaliada, conforme as regras explicitadas anteriormente. É garantido que todas as expressões são bem-formadas e, consequentemente, possuem resposta e que cada expressão possuirá menos que 1000 caracteres. O aluno que não seguir as especificações dadas perderá 0,5 durante a correção, portanto prestem atenção aos nomes dos arquivos!!!

Saída: Nome do arquivo "Expressoes.out"

Para cada caso de teste imprima uma linha contendo "caso #x", onde x indica o número de caso de teste, iniciando de '1'. Na mesma linha, imprima a resposta como "satisfativel" ou "insatisfativel".	Se a entrada não estiver na Fórmula Normal Conjuntiva, imprima "nao esta na FNC" e passe para a próxima expressão. Se a entrada não estiver de modo que todas as cláusulas são de Horn, imprima "nem todas as clausulas sao de horn" e passe para a próxima expressão. 

## Exemplo

Arquivo: "Expressoes.in"

```
2
(x+y)
((x+y).(z.t))
```

Arquivo: "Expressoes.out"

```
Tabela #1 
-----------
|x|y|(x+y)|
-----------
|0|0|    0|
-----------
|0|1|    1|
-----------
|1|0|    1|
-----------
|1|1|    1|
-----------
satisfativel e refutavel
{linha em branco}
Tabela #2
-----------------------------------
|x|y|z|t|(x+y)|(z.t)|((x+y).(z.t))|
-----------------------------------
|0|0|0|0|    0|    0|            0|
-----------------------------------
|0|0|0|1|    0|    0|            0|
-----------------------------------
|0|0|1|0|    0|    0|            0|
-----------------------------------
|0|0|1|1|    0|    1|            0|
-----------------------------------
|0|1|0|0|    1|    0|            0|
-----------------------------------
|0|1|0|1|    1|    0|            0|
-----------------------------------
|0|1|1|0|    1|    0|            0|
-----------------------------------
|0|1|1|1|    1|    1|            1|
-----------------------------------
|1|0|0|0|    1|    0|            0|
-----------------------------------
|1|0|0|1|    1|    0|            0|
-----------------------------------
|1|0|1|0|    1|    0|            0|
-----------------------------------
|1|0|1|1|    1|    1|            1|
-----------------------------------
|1|1|0|0|    1|    0|            0|
-----------------------------------
|1|1|0|1|    1|    0|            0|
-----------------------------------
|1|1|1|0|    1|    0|            0|
-----------------------------------
|1|1|1|1|    1|    1|            1|
-----------------------------------
satisfativel e refutavel
{linha em branco}
{cursor aqui}
```



## Dúvidas Frequentes

■ Do pacote java.util somente poderão ser utilizadas as classes Vector, ArrayList e Scanner.

■ Do pacote java.io somente poderão ser utilizadas as classes BufferedWriter, FileWriter, BufferedReader e FileReader.

■ De C/C++ somente poderão ser utilizadas as bibliotecas cstdio, cstdlib, iostream, string, cstring, vector.

■ A saída deve ser exatamente como está demonstrada na especificação.

■ Não haverá nenhum acento nem ponto na saída.

■ Não haverá espaços no meio da expressão, logo não é necessário o uso do readLine(). Em vez disso, pode-se utilizar o readString().


Obs:Todo o projeto deve ser entregue em uma única classe. É permitido o uso da classe Arquivo de Algoritmos, contanto que o seu monitor seja avisado no e-mail de envio do projeto.
