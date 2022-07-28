# Apache Maven Project
https://maven.apache.org

## Criando um projeto via linha de comando Apache Maven

mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

mvn archetype:generate -DgroupID=one.digitalinnovation -DartifactID=quick-start-maven -DarchetypeArtifactID=maven-archetype-quickstart -DinteractiveMode=false

## Comandos

compile : compilar
test :  testar
package : empacotar e cria um .jar
clean : limpar o diretório de trabalho

Na pasta do projeto -> mvn compile
			     mvn test
                       mvn package

Para consultar
https://mvnrepository.com/