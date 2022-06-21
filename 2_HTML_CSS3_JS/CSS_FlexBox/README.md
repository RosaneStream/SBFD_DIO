# project flexbox DIO

.container
{
display: flex; /* or inline-flex */
}

.flex-container
{
flex-direction: row | row-reverse | column | column-reverse;
}

.flex-container
{
flex-wrap
: nowrap | wrap | wrap-reverse;
}

.flex-container
{
flex-flow: row nowrap | row wrap | column nowrap | column wrap;
}

.flex-container
{
justify-content: flex-start | flex-end | center | space-between | space-around
}

.flex-container
{
align-items: stretch | flex-start | flex-end | center | baseline;
}

.flex-container
{
align-content: flex-start | flex-end | center | space-between | space-around 
}

.flex-item
{
order: <número>;/* o valor padrão é 0 */
}

.flex-item
{
flex-grow: <numero>;/* o valor default(padrão) é 0 */
}

.flex-item
{
flex-shrink: <número>;/* o valor padrão é 0 */
}

.flex-item
{
flex-basis: flex-basis: | auto;/* o valor padrão é auto */
}

.item {
flex: none | [ <'flex-grow'> <'flex-shrink'>? || <'flex-basis'> ]
}

.item
{
align-self: auto | flex-start | flex-end | center | baseline | stretch;
}

align-content - Modifica o comportamento da propriedade flex-wrap. É semelhante a align-items, mas em vez de alinhar itens flexíveis, alinha linhas flexíveis.
align-items - Alinha verticalmente os itens flexíveis quando os itens não usam todo o espaço disponível no eixo cruzado.
align-self - Especifica o alinhamento de um item flexível (substitui a propriedade align-items do contêiner flexível). 
display - Especifica o tipo de caixa usado para um elemento HTML.
flex - Uma propriedade abreviada para as propriedades flex-grow, flex-shrink e flex-basis.
flex-basis - Especifica o comprimento inicial de um item flexível.
flex-direction - Especifica a direção dos itens flexíveis dentro de um contêiner flexível. 
flex-flow - Uma propriedade abreviada para flex-direction e flex-wrap.
flex-grow - Específica quanto um item flexível crescerá em relação ao restante dos itens flexíveis dentro do mesmo contêiner.
flex-shrink - Especifica o quanto um item flexível diminuirá em relação ao restante dos itens flexíveis dentro do mesmo contêiner
flex-wrap - Especifica se os itens flexíveis devem ser agrupados ou não, se não houver espaço suficiente para eles em uma linha flexível.
justify-content - Alinha horizontalmente os itens flexíveis quando os itens não usam todo o espaço disponível no eixo principal.
order - Especifica a ordem dos itens flexíveis dentro do mesmo contêiner.