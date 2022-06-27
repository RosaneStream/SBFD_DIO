const nums = [11,22,33,44,55,66];

const xuxu={value: 2,};
const abobrinha={value:3,};

/*Map com This*/
function map_This(meuArray, ThisArg){
    return meuArray.map(function(item)
    {
       return item * this.value;    

    }, ThisArg);
}

/*Map com This*/
function map_semThis(meuArray){
    return meuArray.map(function(item)
    {  const multiplicador = 2;
       return item * multiplicador;    

    });
}

/*Filter */

function filtrarPares(meuArray){
    return meuArray.filter(callback);

}
function callback(item){
    return item % 2 == 0
}

/*Reduce */

function somarTotal(meuArray){
    return meuArray.reduce(function(prev,current){
        return prev+current;
    });

}

function somarTotal_acc(meuArray){
    return meuArray.reduce(function(acc,current){
        console.log("Acumulador - acc é: ", acc);
        return acc+current;
    });

}

console.log("O array original é: ", nums);

console.log("Map com This");
console.log("Esse This é xuxu: ",map_This(nums,xuxu));
console.log("Esse This é abobrinha: ",map_This(nums,abobrinha));

console.log("Map sem This");
console.log(map_semThis(nums));

console.log("Testando Filter");
console.log("Os pares são: ", filtrarPares(nums));

console.log("Testando Reduce");
console.log("A soma dos números do array é : ", somarTotal(nums));

console.log("A soma dos números current (atual)  + acc (acumulador) : ", somarTotal_acc(nums));


/* Criar lista com preços e calcular saldo disponível*/

const lista = [ 
    {nome: "feijao", valor: 10},
    {nome: "cebola", valor: 12},
    {nome: "massa", valor: 17},
    {nome: "arroz", valor: 25}
];

const saldo = 250;

function calcularSaldoDisponivel(saldoAtual, meuArray){
    return meuArray.reduce (function(prev,current){
        console.log("O prev é: ", prev);
        console.log("O current é : ", current);
      return prev - current.valor;}, saldoAtual);
}



console.log("Testando Reduce com soma de saldo disponível");
console.log("O saldo disponível é : ", calcularSaldoDisponivel(saldo, lista));