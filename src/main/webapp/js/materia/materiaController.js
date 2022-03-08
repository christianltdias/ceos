function criarMateria () {
    data = {'nome': $('#nome').val(), 'descricao': $('#descricao').val(), 'categoriaId': Number($('#categoriaId').val())}
    const materiaModal = $('#criaMateriaModal');
    axios
    .post('/materias/salva', data)
    .then(response => {
        materiaModal.modal('hide');
        })
    .catch(error => {
    })
}