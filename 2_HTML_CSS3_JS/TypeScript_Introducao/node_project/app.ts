enum Profissao {
  'professora', 'desenvolvedora', 'atriz'
}

interface Pessoa  {
  nome: string,
  idade: number,
  profissao?: Profissao
}

interface Estudante extends Pessoa{
  materia: string[];
}

const vanessa: Pessoa = {nome:'Vanessa', idade:27}
const paula: Estudante = {nome:'Paula', idade:47, profissao:Profissao.desenvolvedora, materia:['matematica', 'estatistica']}

const fernanda: Estudante = {nome:'Paula', idade:47, materia:['matematica', 'estatistica']}

function listar(lista:string[]){
  for (const item of lista){
    console.log('- ', item);
  }
}

listar(fernanda.materia);

type entrada = number | string;

function somar(num1: entrada, num2: entrada){
  if (typeof num1 === 'string' || typeof num2 === 'string' ){
    return num1.toString()+num2.toString();
  }
  else{
    return num1+num2;
  }
}

console.log(somar(1,5))
console.log(somar('1',5))
console.log(somar('Ola,',' xuxuzinho'))

function somarTipada(num1: number, num2: number): number{
    return num1+num2;
}

console.log(somarTipada(1,5))