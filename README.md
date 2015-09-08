# MarsOne

## Instalação
Porta padrão: 8080
### Jar
Utilizando o JAR que se encontra na raiz do projeto execute o comando

java -jar 'PATH'/Mars.jar

### Maven
mvn spring-boot:run

## Ferramentas
* Java
* Spring boot
* Maven
* JUnit
* JarxRS (Jersey)
* Guava
* GSON

## Endpoints

 * Path: "/deploy/{malhaH}/{malhaV}/{sonda}"
 * Method: GET
 * Parametros: /'malhaH'/'malhaV'/'sonda'
 > malhaH (int): Tamanho Horizontal da malha

 > malhaV (int): Tamanho Vertival da manha
 
 > sonda (String): Json array que contem as informações da sonda e os comandos, no seguinte formato.
    
    * commands: L, M, R
    * direction: N, S, E, W
 ```
 [{
    horizontal: 10,
    vertical: 10,
    direction: N,
    commands: [M,L,R,M,M,R,M]
 },
 ...]
 ```
 * Exemplo: http://localhost:8080/5/5/[{horizontal: 1,vertical: 2, direction: N, commands: [L,M,L,M,L,M,L,M,M] }]
