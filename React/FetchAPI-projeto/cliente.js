const inforamcoesClientes = [
    {
        cpf:66809433023,
        nome:"Jairo"
    } 
];

const coneteudoLinha = ` <tr>
<td>${inforamcoesClientes[0].cpf}</td>
<td>${inforamcoesClientes[0].nome}</td>
<td></td>
</tr>`;

const corpoTabela = document.querySelector('[data-conteudo-tabela]');
corpoTabela.innerHTML = coneteudoLinha;

