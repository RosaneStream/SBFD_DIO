"use strict";
/**
 * Caso algum dos Ids abaixo não esteja presente no index.html, a função não vai retornar os itens e isso pode causar erros no resto do arquivo.
*/
//const button = document.getElementById('button'); 
//const input1 = document.getElementById('input1');
//const input2 = document.getElementById('input2');
/**
 * A função abaixo não valida se os itens somados são número. Logo situações inesperadas podem ocorrer.
 * Por exemplo, somarSemValidar(1, "3") vai devolver "13"
*/
//function somarSemValidar(numero1, numero2) {
//  return numero1 + numero2;
//}
//button.addEventListener('click', () => {
//   console.log(somarSemValidar(input1.value, input2.value));
//});
/**
 * Na função abaixo uma validação é feita para confirmar se os itens são números e é feita uma conversão caso não sejam.
*/
/*function somarValidando(numero1, numero2) {
    if (typeof numero1 !== 'number' || typeof numero2 !== 'number') {
        return +numero1 + +numero2;
    } else {
        return numero1 + numero2;
    }
}

button.addEventListener('click', () => {
    console.log(printarSomaValida(input1.value, input2.value));
});
*/
let button = document.getElementById("button");
let input1 = document.getElementById("input1");
let input2 = document.getElementById("input2");
function somar(numero1, numero2, devePrintar, frase) {
    if (devePrintar) {
        let resultado = numero1 + numero2;
        console.log(frase + resultado);
        return resultado;
    }
}
let devePrintar = true;
let frase = "O resultado é: ";
if (button) {
    button.addEventListener('click', () => {
        if (input1 && input2) {
            console.log(somar(Number(input1.value), Number(input2.value), devePrintar, frase));
        }
    });
}
//# sourceMappingURL=Somar_Valida.js.map