function criarLicitacao () {
    data = {'nome': $('#nome').val(), 'descricao': $('#descricao').val(), 'valor': Number($('#valor').val()), 'materiaId': Number($('#materiaId').val())}
    const licitacaoModal = $('#criaLicitacaoModal');
    axios
    .post('/licitacoes/salva', data)
    .then(response => {
        licitacaoModal.modal('hide');
        })
    .catch(error => {
    })
}