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
* Log ideal para ver merge ou rebase de branch.
```

git log --graph

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
* Clonar o repositório.
```
git clone [Local do repositório] [ Opcional - nome da pasta]

```
* Empurrar para o repositório remoto.
```
git push [repositório remoto] [nome da branch]
 
```
* Atulizar o repositório local. *usar sempre antes de um push para atulizar os arquivos*.
```
git pull [repositório remoto] [nome da branch]

```
* Criar uma branch.
```

git branch [nome da branch]

```
* Trocar para outra branch.
```
git checkout titulo

```
* Criar uma branch e trocar para ela.
```

git checkout -b [nome da branch]

```
* Unir uma branch a master. *Executar na master*.
```
git merge titulo

```
* Rebase de uma branch. *Executar na master*.
```

git rebase [nome da branch]

```
* Desfazer arquivos que estejam em modo para serem adicionados ao commit, state modified.
```

git checkout -- [nome do arquivo]

```
* Desfazer arquivos que estavam para serem commitados, state staged.
```

git reset HEAD [nome do arquivo]

```
* Desfazer algo que já foi commitado, state unmodified.
```

git revert [hash do commit] // use o comando git log --oneline para ver o hash resumido

```
*  Enviar arquivos alterados para um local temporário, sem necessidade de um commit ou de se gerar um commit para isto.
```

git stash

```
* Listar arquivos salvos no local temporário.
```

git stash list

```
* Aplicar alterações que estão na stash.
```

git stash apply [numero da stash]

```
* Remover as alterçãoes já feitas da stash.
```

git stash drop

```
* Aplicar as alterações e remover da stash.
```

git stash pop

```
* Mandar a head para algum commit especifico. *Para manter as alterações feitas é necessário criar uma branch nesse commit especifico*.
```
git checkout [hash do commit]

```
* Ver as diferenças entre commits. Interpretar .. como até.
```
git diff [hash do commit]..[hash do commit]

```
* Criar uma tag
```

git tag -a [versão] -m "[Descrição da versão - opcional]"

```
