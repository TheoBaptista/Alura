# Armazenamento no docker

Há alguns tipos de armazenamento no docker.
---
* Bind mount, quando uma pasta no diretorio da maquina relfete em outra no container. Precisamos fazer referência ao caminho absoluto da pasta no nosso host.
```
docker run -it  -v /home/usuario/backup:/app ubuntu:16.04
```
* Volume criado automáticamente pelo docker, e gerenciado pelo docker. Não dependendo da estrutura de pastas do sistema do host.
```
dokcer run -it -v /app ubuntu:16.04
```
* Volume criado pelo usuário. 
```
docker volume create NOME_DO_VOLUME

dokcer run -it -v NOME_DO_VOLUME/app ubuntu:16.04

```
* Volume criado temporariamente na memória ram do host .
```
dokcer run -it --tmpfs /app ubuntu:16.04
```
---
### A recomendação do próprio docker é usar outra flag para indicar qual dos tipos de armazenamento será usado.
```
dokcer run -it --mount type=tmpfs,target=/app  ubuntu:16.04
```
---
```
dokcer run -it --mount type=bind,source=/home/usuario/backup,target=/app  ubuntu:16.04
```
---
```
dokcer run -it --mount source=NOME_DO_VOLUME,target=/app  ubuntu:16.04
```
