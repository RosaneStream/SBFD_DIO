function verificarPalindromo(string){
    if(!string) throw "String invalida!";

    return string === string.split('').reverse().join('');
}

/*Try catch finally exemplo */
function EnviarPalavra(palavra)
{   
    try {

        reverso = verificarPalindromo(palavra);
    }
    catch (e)
    {
        console.log(e);
    }
    finally{
        console.log("1- A palavra enviada é: ", palavra);
        console.log("É um palindromo?", reverso);

    }
/*Outro exemplo throw finally*/
    try {

        reverso = verificarPalindromo(palavra);
    }
    catch (e)
    {
        throw e;
    }
    finally{
        console.log("2- A palavra enviada é: ", palavra);
        console.log("É um palindromo?", reverso);

    }

}

console.log(EnviarPalavra("ana"));

/*validar array para testar erro*/

function validarArray(arr, num){
    try {

        let meuArray = arr;

        console.log(meuArray);

        if (!meuArray && !num) throw new ReferenceError('Parametros invalidos!');

        if(typeof meuArray !== 'object') 
            throw new TypeError ("O array precisa ser objeto!");
        
        if(typeof num!== 'number') 
            throw new TypeError ("O num precisa ser número!");

        if (meuArray.length !== num) throw new RangeError("O tamanho do array deve ser "+ meuArray.length);

        return meuArray;

        
        
    } catch (e) {
        console.log(e.name);
        console.log(e.stack);
        console.log(e.message);
                
        if (e instanceof ReferenceError){
            console.log("Este é um ReferenceError");  
        } else
        if (e instanceof TypeError){
            console.log("Este é um TypeError");
        } else
        if (e instanceof ReferenceError){
            console.log("Este é um RangeError");
        } else
        console.log("Erro desconhecido: ", e);
        
    }
    finally{
        console.log("Erros já foram tratados!")

    }

}

const arr = [2,3,4,5,6];
//console.log(validarArray());
//console.log(validarArray(6,6));
//console.log(validarArray(arr,"bbbb"));
console.log(validarArray(arr,6));
//console.log(validarArray(arr,5));
