# Montando um dockerfile
* Geralmente, montamos as nossas imagens a partir de uma imagem já existente. Nós podemos criar uma imagem do zero, mas a prática de utilizar uma imagem como base e adicionar nela o que quisermos é mais comum.  Primeiro é necessário utilizarmos a palavra FROM mais o nome da imagem.
```
FROM node
```
* Além disso, podemos indicar a versão da imagem que queremos, ou utilizar o latest, que faz referência à versão mais recente da imagem. Se não passarmos versão nenhuma, o Docker irá assumir que queremos o latest.
```
FROM node:latest
```
* Outra instrução que é comum colocarmos é quem cuida, quem criou a imagem
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
```
* Agora, especificamos o que queremos na imagem. Neste caso, coloquei o código dentro da imagem, então utilizaremos o COPY. Como queremos copiar tudo o que está dentro da pasta, vamos utilizar o . para copiar tudo que está na pasta do arquivo Dockerfile, e vamos copiar para /var/www.
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
COPY . /var/www
```
* Queremos que a própria imagem instale as dependências para nós, rodando o comando npm install. Para executar um comando, utilizamos o RUN.
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
COPY . /var/www
RUN npm install
```
* O ENTRYPOINT executará os comandos que quisermos assim que o container for carregado.
Também podemos passar os comandos como se fosse em um array, ambos funcionam.
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
COPY . /var/www
RUN npm install
ENTRYPOINT npm start
```
* Falta colocarmos a porta em que a aplicação executará, a porta em que ela ficará exposta. Para isso, utilizamos o EXPOSE. Para criar variáveis de ambiente, utilizei o ENV. Por exemplo, para criar a variável PORT, para dizer em que porta a nossa aplicação irá rodar.
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
ENV PORT=3000
COPY . /var/www
RUN npm install
ENTRYPOINT npm start
EXPOSE $PORT
```
* Por fim, falta dizermos onde os comandos rodarão, pois eles devem ser executados dentro da pasta /var/www. Então, através do WORKDIR, assim que copiarmos o projeto, dizemos em qual diretório iremos trabalhar;
```
FROM node:latest
LABEL maintainer="Douglas Quintanilha"
ENV PORT=3000
COPY . /var/www
WORKDIR /var/www
RUN npm install
ENTRYPOINT npm start
EXPOSE $PORT
```

### Resta agora criar a imagem.
Para criar a imagem, precisamos fazer o seu build através do comando docker build, comando utilizado para buildar uma imagem a partir de um Dockerfile. Para configurar esse comando, passamos o nome do Dockerfile através da flag -f.
```
docker build -f nomeDoArquivo.dockerfile
```
Além disso, passamos a tag da imagem, o seu nome, através da flag -t. Já vimos que para imagens não-oficiais, colocamos o nome no padrão NOME_DO_USUARIO/NOME_DA_IMAGEM, então é isso que faremos, por exemplo.
```
docker build -f nomeDoArquivo.dockerfile -t nome_do_usuario/nome_da_imagem
```
E agora dizemos onde está o Dockerfile. No caso do exemplo abaixo, já estamos na pasta.
```
docker build -f nomeDoArquivo.dockerfile -t nome_do_usuario/nome_da_imagem .
```
Ao executar o comando, podemos perceber que cada instrução executada do nosso Dockerfile possui um id. Isso por que para cada passo o Docker cria um container intermediário, para se aproveitar do seu sistema de camadas. Ou seja, cada instrução gera uma nova camada, que fará parte da imagem final, que nada mais é do que a imagem-base com vários containers intermediários em cima, sendo que cada um desses containers representa um comando do Dockerfile.

Assim, se um dia a imagem precisar ser alterada, somente o container referente à instrução modificada será alterado, com as outras partes intermediárias da imagem já prontas.



