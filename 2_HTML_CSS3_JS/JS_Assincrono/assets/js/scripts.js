
/*Exemplo JS Assincrono para consumir API */

/* guarda o endereço da API a ser consumida numa constante ou variavel */
const BASE_URL = 'https://thatcopy.pw/catapi/rest/';
const btn = document.getElementById('change-cat');

/* função para carregar a API */
const getCats = async () => {
	try {
		/* Busca na URL informações sobre o objeto (GET), como cabeçalhos, código de status etc */
		const data = await fetch(BASE_URL);
		/*converte a resposta para json */
		const json = await data.json();
		console.log(json);
		/*retorna a propriedade webpurl, onde tem o endereço da imagem */
		/*{"id":9,"url":"https://thatcopy.github.io/catAPI/imgs/jpg/2b74f7c.jpg",
		   "webpurl":"https://thatcopy.github.io/catAPI/imgs/webp/2b74f7c.webp","x":53.47,"y":49.09} */
		return json.webpurl;
	} catch (e) {
		console.log(e.message);
	}
};

const loadImg = async () => {
	const img = document.getElementsByTagName('img')[0];
	img.src = await getCats();
};

btn.addEventListener('click', loadImg);
loadImg();