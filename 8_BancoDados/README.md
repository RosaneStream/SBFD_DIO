# Comandos SQL

INSERT INTO cidades(codigo, nome, populacao, estado) VALUES(20, ‘Campos do Jordão’,65000,’SP’);

Exemplo para alterar dados:

UPDATE cidades set nome=’Poços de Caldas’, populacao=120000, estado=’MG’

WHERE CODIGO=20;

Exemplo para excluir dados:

DELE FROM cidades

WHERE CODIGO=20;


Estrutura do comando Select:

SELECT - Seleciona as colunas da consulta
FROM - Seleciona a(s) tabela(s)
WHERE - Permite criar condições para filtrar os dados retornados na consulta
GROUP BY Agrupa dados na consulta.
HAVING Limita o resulta em uma condição estabelecida.
ORDER BY Especifica a coluna ou as colunas que serão ordenadas na consulta
Usando o Select na forma básica
Select * FROM empregados


Selecionando colunas específicas para a consulta
SELECT nome,salario, cidade
FROM empregados


Renomeando colunas
SELECT nome, data_nascimento As Aniversario, cidade As residencia
FROM empregados


O Mysql trata concatenação de forma diferente do SQL Server e do Access, enquanto que no Mysql usamos a função concat(), no SQL Server e no Access fazemos pelo sinal de adição.

Exemplo de concatenação no Mysql:

SELECT concat(nome, *** mora em ***, cidade, ***/***, estado
FROM empregados

Exemplo de concatenação em SQL Server ou Access

SELECT nome + *** mora em *** + cidade + ***/*** + estado
FROM empregados

O sinal + (mais) indica concatenação e deve ser usado para concatenar colunas ou uma coluna com um texto. Só poderá ser concatenado colunas do tipo texto, caso for necessário concatenar colunas do tipo data ou numérico, é necessário fazer a conversão dessas colunas para texto.

A função CONVERT() do SQL Server é usada para fazer a conversão de valores de uma coluna.

Exemplo 1:

SELECT nome + *** ganha *** + convert(varchar, salario)
FROM empregados

Exemplo 2:

SELECT nome + *** nasceu em *** + Convert(VarChar, data_nascimento, 103)
FROM empregados

No primeiro caso, estamos convertendo o valor da coluna salário para texto, já que esta coluna é do tipo Decimal.

No segundo exemplo, estamos convertendo o valor de uma coluna do tipo data para texto. Perceba que neste caso usamos o 103 na função, isto é necessário para informarmos que queremos que a data seja convertida no formato dd/mm/aaaa.

Selecionando valores distintos
Para eliminar linhas duplicadas, usamos a palavra-chave DISTINCT na cláusula SELECT.

SELECT distinct cidade
FROM empregados

No exemplo acima, usamos a palavra-chave distinct na coluna cidade, mas é possível relacionar mais de uma coluna, por exemplo, cidade e estado. Neste caso a combinação das duas colunas deve ser distinta.

Limitando o nº de linhas em uma consulta
Limitar o número de linhas é usado quando não queremos listar todas as linhas de uma tabela, seja pelo volume de linhas ou por não haver necessidade. O Mysql trata esta questão de forma diferente do SQL Server e do Access.

Em SQL Server e Access use o Top para indicar o limite de linhas desejado na consulta.

SELECT top 7 *
FROM empregados

Em Mysql use o Limit para indicar o limite de linhas desejado na consulta.

SELECT *
FROM empregados limit 0,7

O resultado será o mesmo, porém a leitura pode ser um pouco diferente, já que o top vai pegar as sete primeiras linhas e o limit vai pegar a partir de 0 até 7.