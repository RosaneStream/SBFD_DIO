"use strict";
/*Object******************************************************************/
/**
 * A inferência de tipo também funciona para objetos.
 * Se estiver usando o visual studio code, tente passar o mouse por cima de um objeto não tipado e veja a mágica.
*/
const desenvolvedor = {
    name: 'Marco',
    idade: 25,
    salario: 15000
};
/**
* desenvolvedor.salario = "não tem" devolveria um erro, pois foi inferido que desenvolvedor.salario é do tipo number
* Assim percebemos que enquanto o objeto pode ser escrito de qualquer forma, o uso posterior tem que respeitar a forma como ele foi inicializado
*/
// Nesse caso abaixo a tipagem foi explícita, então é necessário respeitar o tipo durante a criação do objeto.
const carro = {
    cor: 'vermelho',
    numeroDoPneu: 10,
    conversivel: true
};
/**
* Com esses dois exemplos percebemos que objetos seguem as mesmas regras de variáveis comuns
* Ambos podem ser inicializadas de qualquer forma, mas depois precisam respeitar o tipo
* E caso sejam tipados no início, seu primeiro valor tem que respeitar esse tipo
*/
// Vamos usar pela primeira vez o tipo lista
const estudante = {
    nome: 'Amanda',
    idade: 24,
    materias: ['Algoritmos', 'Lógica para computação']
};
function listarMateriais(lista) {
    for (const item of lista) {
        console.log('- ' + item);
    }
}
// A função reconhece estudante.materias como string[]
listarMateriais(estudante.materias);
/*Function******************************************************************/
// O Typescript infere (deduz) que o retorno da função é do tipo number
function adicionar(n1, n2) {
    return n1 + n2;
}
let resultado;
// O retorno da função pode ser atribuido a variavel do mesmo tipo inferido
resultado = adicionar(1, 4);
/**
* Aqui temos uma função que retorna uma string por causa do uso de toString(). Ela é praticamente igual a função acima, com apenas uma pequena alteração diferindo as duas
* Como o dia a dia dos desenvolvedores é corrido, pequenas mudanças como essa podem ocorrer o tempo todo alterando uma função
* Essa estrutura parece frágil e suscetível a erros e não é isso que queremos com typescript
*/
function adicionarNumeros(n1, n2) {
    return n1.toString() + n2;
}
/**
* resultado = adicionarNumeros(1, 4);
* No caso acima um erro vai ser apresentado porque, por inferência, o retorno de adicionarNumeros é do tipo string e resultado espera um number
* Então temos um problema aqui, porque funções podem ser alteradas e isso pode implicar em erros em outras partes do código.
*/
// Uma solução para isso é explicitamente tipar o retorno de uma função. Se algo for modificado dentro dela, o próprio TS pode reclamar caso o retorno não seja number
function adicionarExplicitamenteNumber(n1, n2) {
    return n1 + n2;
}
resultado = adicionarExplicitamenteNumber(1, 4);
// Funções também podem não retornar nada, que é o caso do tipo void
function printarValor(num) {
    console.log('O valor é ' + num);
}
printarValor(3);
function multiplicarValorPor2(numero) {
    return numero * 2;
}
/**
* Funções também podem ser passadas como parâmetro. O tipo delas é estruturado assim:
* (parâmetro: tipo do parâmetro) => tipo do retorno
*/
function adicionarETratar(n1, n2, callback) {
    resultado = n1 + n2;
    callback(resultado); // Aqui ela é chamada 
}
adicionarETratar(1, 5, printarValor);
console.log(adicionarETratar(1, 5, multiplicarValorPor2));
//# sourceMappingURL=app.js.map