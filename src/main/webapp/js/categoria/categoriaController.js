function criarCategoria () {
    data = {'nome': $('#nome').val(), 'descricao': $('#descricao').val(), 'urlImagem': $('#urlImagem').val()}
    const categoriaModal = $('#criaCategoriaModal');
    axios
    .post('/categorias/salva', data)
    .then(response => {
        categoriaModal.modal('hide');
        })
    .catch(error => {
    })
}