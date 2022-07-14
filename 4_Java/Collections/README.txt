Metodos lista

[x] Iniciar
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html
[x] Generics
[x] Diamond Operator
https://www.baeldung.com/java-diamond-operator
[x] toString()
[x] indexOf()
[x] add()
[x] set()
[x] contains()
[x] toString()
[x] get()
[x] Collections.min()
[x] Collections.max()
[x] iterator()
[x] iterator().hasNext()
[x] iterator().next()
[x] size()
[x] remove()
[x] iterator().remove()
[x] clear()
[x] isEmpty()


Exercicio Ordenação Lista

[x] class Gato - nome, idade, cor
[x] new ArrayList()
[x] Collections.shuffle()
[x] Collections.sort()
[x] sort()
[x] Comparable
https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
[x] new ComparatorIdade()
[x] new ComparatorCor()
[x] new ComparatorNomeGeneroTempoEpisodio()

Metodos SET

Não trabalha com indices, 
não remove conteudo numa posição
não busca conteudo de acordo com a posição (não tem GET nem SET)
Não ordena e não insere o elementos repetidos
Não substitui conteudos por valor
quantidade é size, não length
treeSet organiza de forma crescente (Onde tem comparable ou comparator)

LinkedHashSet permite exibir na ordem de inserção



x] class Serie - nome, gênero, tempoEpisodio
[x] equals and hashcode
https://dzone.com/articles/working-with-hashcode-and-equals-in-java
[x] new HashMap()
[x] new LinkedHashMap()
[x] new TreeSet()
[x] Comparable
[x] addAll
[x] ComparatorNomeGeneroTempoEpisodio()

[x] Iniciar
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Set.html
[x] toString()
[x] contains()
[x] toString()
[x] Collections.min()
[x] Collections.max()
[x] iterator()
[x] iterator().hasNext()
[x] iterator().next()
[x] size()
[x] remove()
[x] iterator().remove()
[x] new LinkedHashMap()
[x] new TreeMap()
[x] clear()
[x] isEmpty()


Metodos Map - NAO PERTENCE AO COLLECTIONS

[x] class Livro - nome e qtdPaginas
[x] new HashMap()
[x] new LinkedHashMap()
[x] new TreeMap()
[x] new TreeSet()
[x] addAll
[x] new ComparatorNomeLivro()

[x] Iniciar
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
[x] toString()
[x] put()
[x] containsKey()
[x] get()
[x] keySet()
[x] values
[x] entrySet();
[x] getValue();
[x] getKey();
[x] iterator()
[x] iterator().hasNext()
[x] iterator().next()
[x] LinkedHashMap()
[x] new TreeMap()
[x] clear()
[x] isEmpty()


API Stream - metodos

[x] stream - Fluxo de dados que não altera a coleção
https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
https://medium.com/@racc.costa/streams-no-java-8-e-no-java-9-36177c5c3313
https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
[x] operações intermediárias - Permite operações encadeadas
[x] operações finais - Fecha o fluxo
https://www.geeksforgeeks.org/stream-in-java/
---
[x] forEach(new Consumer())
[x] skip()
[x] collect(Collectors.joining())
[x] distinct()
[x] count()
[x] limit()
[x] collect(Collectors.toSet())
[x] map(new Function())
[x] collect(Collectors.toList())
[x] filter (new Function())
[x] sorted()
[x] mapToInt
[x] sum()
[x] average()
[x] ifPresent()
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html
https://www.baeldung.com/java-optional
[x] min
[x] max
*[x] removeIf(new Predicate())
[x] collect(Collectors.groupingBy(new Function())


[x] classe anônima
[x] functional interface
Qualquer interface com um SAM (Single Abstract Method) é uma interface funcional e sua implementação pode ser tratada como expressões lambda.
https://www.baeldung.com/java-8-functional-interfaces
[x] Comparator
[x] lambda '->'
É uma função anônima com a qual podemos lidar como um cidadão de língua de primeira classe. Por exemplo, podemos passá-lo ou retorná-lo de um método.
https://www.baeldung.com/java-8-lambda-expressions-tips
[] reference method '::'
É um tipo especial de expressões lambda. Eles costumam ser usado para criar expressões lambda simples fazendo referência a métodos existentes.
https://www.baeldung.com/java-method-references


Implementando Collections e Streams com Java - Wesley Fuchter

Desenvolvimento Avançado em Java - João Paulo