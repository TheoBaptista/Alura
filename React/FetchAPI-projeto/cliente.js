const informacoesClientes = [
    {
        cpf: 66809433023,
        nome: "Jairo"
    },
    {
        cpf:12345678910,
        nome: "Pedro"
    },
    {
        cpf:0123456,
        nome: "Jack"
    }
];



const corpoTabela = document.querySelector('[data-conteudo-tabela]');


const exibeCliente = (cpf, nome) => {

    const linha = document.createElement('tr');

    const coneteudoLinha = ` 
        <td>${cpf}</td>
        <td>${nome}</td>
        `;

linha.innerHTML = coneteudoLinha;
return linha;
}


informacoesClientes.forEach(
    (indice) => {
            corpoTabela.appendChild(exibeCliente(indice.cpf,indice.nome));
    }
)