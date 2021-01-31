# Principais comandos do docker e dicas para utilização.
---
* Baixar a imagem docker.
```
docker pull [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container com a respectiva imagem passada como parâmetro. Baixará a imagem do [Docker Hub](https://hub.docker.com/), caso não exista no repositório local.
```
docker run [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container e usar o modo interativo. flags -it, -a de attach, para integrar os terminais, e -i, de interactive.
```
docker run -it [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container detached.
```
docker run -d [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container e atribuir uma porta aleatória ao container.
```
docker run -P [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container e atribuir uma porta.
```
docker run -p PORTA-MUNDO-EXTERNO:PORTA-CONTAINER [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container e atribuir um nome a ele.
```
docker run --name [nome para o container] [nome do usuário]/NOME_DA_IMAGEM
```
* Criar um container e atribuir uma variável de ambiente.
```
docker run -e VARIAVEL= "valor da variavel"  [nome do usuário]/NOME_DA_IMAGEM
```
* ver os containers que estão sendo executados no momento.
```
docker ps
```
* Para ver todos containers, inclusive os parados, adicionamos a flag -a.
```
docker ps -a
```
* ver apenas os ids dos containers que estão rodando
```
docker ps -q
```
* Executar um container que está parado.
```
docker start ID_DO_CONTAINER
```
* Parar um container que está executando.
```
docker stop ID_DO_CONTAINER
```
* Inicia o container com id em questão e integra os terminais, além de permitir interação entre ambos.
```
docker start -a -i ID_CONTAINER
```
* Para remover um container.
```
docker rm ID_DO_CONTAINER
```
* Remove a imagem passada como parâmetro.
```
docker rmi NOME_DA_IMAGEM
```
* Para remover todos os containers parados.
```
docker container prune
```
* Uma maneira de ver as portas passando para ele o id do container.
```
docker port ID_DO_CONTAINER
```
* Parar todos os containers de uma só vez.
```
docker stop $(docker ps -q)
```
* Diminuir o tempo de espera ao parar os containers
```
docker stop -t 0 ID_DO_CONTAINER
```
* Inspecionar um container
```
docker inspect ID_DO_CONTAINER
```
* Podemos passar comandos para serem executados pelo container e indicar onde esses comandos vão ser executados indicando a Working Directory flag -w . 
```
docker run -p 8080:3000 - -w "www/sourceCode" [comandos para serem executados]
```
* Mostra o ip atribuído ao container pelo docker (funciona apenas dentro do container).
```
hostname -i
```
* Cria uma rede especificando o driver desejado.
```
docker network create --driver bridge NOME_DA_REDE
```
* Cria um container especificando seu nome e qual rede deverá ser usada.
```
docker run -it --name NOME_CONTAINER --network NOME_DA_REDE NOME_IMAGEM
```
### Arquivos com informações sobre volume, dockerfile, docker-compose.
