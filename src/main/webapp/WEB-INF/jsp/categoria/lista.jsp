<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/topMenu.jspf"%>
<script src="<%=request.getContextPath()%>/js/categoria/categoriaController.js"></script>

<div class="container-fluid">

    <sec:authorize access="hasAuthority('TAREFA_ADD_CATEGORIA')">
        <div class="act-box mt-3 shadow-sm rounded d-flex justify-content-end">
            <button type="button" class="btn btn-add" data-bs-toggle="modal" data-bs-target="#criaCategoriaModal">
                Adicionar
            </button>

            <div class="modal fade" id="criaCategoriaModal" tabindex="-1" aria-labelledby="criaCategoriaModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalCriarCategoria">
                            <i class="bi bi-file-earmark-plus text-icon"></i>Adicionar uma nova categoria</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body p-3">
                            <form>
                                <div class="form-group my-3">
                                    <label for="nome" class="mb-3">Nome</label>
                                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome categoria">
                                </div>
                                <div class="form-group my-3">
                                    <label for="urlImagem" class="mb-3">Url Imagem</label>
                                    <input type="text" class="form-control" id="urlImagem" name="urlImagem" placeholder="Url Imagem">
                                </div>
                                <div class="form-group mb-3">
                                    <label for="descricao">Descrição</label>
                                    <textarea class="form-control" id="descricao" name="descricao" rows="3" placeholder="Descrição"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-add" onClick="criarCategoria()">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
    <div class="mt-3 row cat-container">
        <c:forEach var="categoria" items="${categorias}">
            <div class="p-3 col-3 h-100">
                <div class="card h-100">
                    <img src="${categoria.urlImagem}" class="card-img-top" alt="${categoria.nome}">
                    <div class="card-header">
                        <p class="card-text">${categoria.nome}</p>
                    </div>
                    <div class="card-body">
                        <p class="card-text">${categoria.descricao}</p>
                        <a href="/materias/categoria/${categoria.id}" class="btn btn-primary">Ir</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
