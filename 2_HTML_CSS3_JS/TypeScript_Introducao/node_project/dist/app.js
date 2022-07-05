var Profissao;
(function (Profissao) {
    Profissao[Profissao["professora"] = 0] = "professora";
    Profissao[Profissao["desenvolvedora"] = 1] = "desenvolvedora";
    Profissao[Profissao["atriz"] = 2] = "atriz";
})(Profissao || (Profissao = {}));
const vanessa = { nome: 'Vanessa', idade: 27 };
const paula = { nome: 'Paula', idade: 47, profissao: Profissao.desenvolvedora, materia: ['matematica', 'estatistica'] };
const fernanda = { nome: 'Paula', idade: 47, materia: ['matematica', 'estatistica'] };
function listar(lista) {
    for (const item of lista) {
        console.log('- ', item);
    }
}
listar(fernanda.materia);
function somar(num1, num2) {
    if (typeof num1 === 'string' || typeof num2 === 'string') {
        return num1.toString() + num2.toString();
    }
    else {
        return num1 + num2;
    }
}
console.log(somar(1, 5));
console.log(somar('1', 5));
console.log(somar('Ola,', ' xuxuzinho'));
function somarTipada(num1, num2) {
    return num1 + num2;
}
console.log(somarTipada(1, 5));
//# sourceMappingURL=app.js.map