// O any é uma notação que diz que a propriedade pode ter qualquer tipo
let cpf: any;
// Aqui ela recebe uma string
cpf = '01620445000';
// Aqui recebe um boolean
cpf = true;
// E agora um número
cpf = 10;
// O uso de any faz com que typescript trate suas variáveis como JS

// Essa função abaixo espera uma string
function apresentarCPF(cpf: string) {
    console.log(cpf)
}

// E aqui passamos a variável cpf que contém um number, mas como ela é um any, o TS não reclama porque ela pode conter qualquer atributo, inclusive uma string
apresentarCPF(cpf); 
/**
    Usar any tira poder do typescript e pode criar incoerências no seu projeto
    O any é comumente usado quando um objeto desconhecido é manipulado, ou quando uma refatoração de JS para TS é aplicada rapidamente sem tipar os objetos utilizados
    É uma má prática que reduz a velocidade dos times no longo prazo e foge do propósito do typescript
    Com o uso do ESLint é possível configurar seu projeto para não permitir o uso explícito de any
 */


let valor: unknown; // unknown é um tipo que pode receber qualquer valor
valor = 5;
valor = 'Max';
let nome: string;

// O unknown exige um teste antes de receber outra variavel
// nome = valor; Isso não vai funcionar. O tipo unknown não pode ser arbitrariamente atribuído
if (typeof valor === 'string') {
    nome = valor; // Isso funciona. Esse tipo só pode ser atribuido se uma validação for feita
}

let valorAny: any; // Como já foi visto, o any também recebe qualquer valor
valorAny = true;
valorAny = 10
nome = valorAny; // O perigo é que o any pode ser atribuído a qualquer variável tipada sem que seu tipo seja verificado

// Não é uma prática ruim usar unknown, já que ele força uma validação de tipos. Diferente do any, que como já vimos pode ser usado sem se preocupar com tipage.

function geradorDeErro(mensagem: string, codigoDeErro: number): never { // never quer dizer que o script pode ser interrompido ou nunca chegar a um fim
    throw {message: mensagem, errorCode: codigoDeErro }; // Nesse caso ele foi interrompido
}

geradorDeErro('Um erro ocorreu!', 500); // O mesmo tipo poderia ser usado se fosse usado um while loop que nunca é finalizado