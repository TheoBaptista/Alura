const corpoTabela = document.querySelector('[data-conteudo-tabela]');

const removeCliente = id => {
    if(confirm("Deseja deletar o cliente ? ")){
        deletaCliente(id);
    }

}

const exibeCliente = (cpf, nome, id) => {

    const linha = document.createElement('tr');

    const coneteudoLinha = ` 
        <td>${cpf}</td>
        <td>${nome}</td>
        <button type="button" class="btn btn-danger" onclick="removeCliente(${id})">Excluir</button>
        <a href="edita-clientes.html?id="${id}"><button class="btn btn-success">Editar</button></a>
        `;

    linha.innerHTML = coneteudoLinha;
    return linha;
}


listarClientes().then(exibe => {
    exibe.forEach(
        indice => {
            corpoTabela.appendChild(exibeCliente(indice.cpf, indice.nome, indice.id));
        }
    )
})