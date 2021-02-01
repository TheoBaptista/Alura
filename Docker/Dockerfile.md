# Montando um dockerfile
* Geralmente, montamos as nossas imagens a partir de uma imagem já existente. Nós podemos criar uma imagem do zero, mas a prática de utilizar uma imagem como base e adicionar nela o que quisermos é mais comum.  Primeiro é necessário utilizarmos a palavra FROM mais o nome da imagem.
```
FROM node
```
* Além disso, podemos indicar a versão da imagem que queremos, ou utilizar o latest, que faz referência à versão mais recente da imagem. Se não passarmos versão nenhuma, o Docker irá assumir que queremos o latest.
```
FROM node:latest
```
