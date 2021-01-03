# Comandos do git mais importantes para o dia-a-dia, além de algumas dicas.

* Inicializar o repositório git.
```

git init

```
* Parâmetro que indica que o repositório é puro, que contém apenas as alterações dos arquivos, e não uma cópia física de cada um dos arquivos.
```
git init --bare
```
* Informar quem é você para que armazene corretamente os dados do autor de cada uma das alterações no código, estando na pasta do repositório git. 

```

git config --local ou --global user.name "Seu nome aqui"
git config --local ou --global user.email "seu@email.aqui"

```

* Mostar o estado do repositório.
```

git status

```
* Adicionar um arquivo para ser monitorado.
```

git add [Nome do arquivo]

```
* Adicionar todos os arquivos para serem monitorado.
```
git add .

```
* Remover o monitoramente de um arquivo após ser adicionado, "git add".
```
git rm
 
```
* Commitar as alterações realizadas.
```
git commit -m "Mensagem de commit"

```
* Verificar o histórico de alterações, cada mensagem de commits feitos. [Site com diversos parametros para o git log](https://devhints.io/git-log)
```
git log

```
* Listar todos os repositórios remotos.
```

git remote

```
* Adicionar um repositório remoto. Atenção! O caminho pode ser uma URL de um servidor pela internet, um endereço na rede, inclusive de outro computador, qualquer endereço válido para um repositório Git.
```

git remote add [Nome do repositório remoto] [caminho para ele]
 
```
* Ver o endereço dos repositórios remotos salvos.
```
git remote -v

```
* Clonar o repositório
```
git clone [Local do repositório] [ Opcional - nome da pasta]

```
* Empurrar para o repositório remoto
```
git push [repositório remoto] [nome da branch]
 
```


