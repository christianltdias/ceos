<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/topMenu.jspf"%>
<script src="<%=request.getContextPath()%>/js/materia/materiaController.js"></script>
<div class="container-fluid">
    <sec:authorize access="hasAuthority('TAREFA_ADD_CATEGORIA')">
        <div class="act-box mt-3 shadow-sm rounded d-flex justify-content-end">
            <button type="button" class="btn btn-add" data-bs-toggle="modal" data-bs-target="#criaMateriaModal">
                Adicionar
            </button>

            <div class="modal fade" id="criaMateriaModal" tabindex="-1" aria-labelledby="criaMateriaModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalCriarMateria">
                            <i class="bi bi-file-earmark-plus text-icon"></i>Adicionar uma nova materia</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body p-3">
                            <form>
                                <div class="form-group my-3">
                                    <label for="nome" class="mb-3">Nome</label>
                                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome Materia">
                                </div>
                                <div class="form-group mb-3">
                                    <label for="descricao">Descrição</label>
                                    <textarea class="form-control" id="descricao" name="descricao" rows="3" placeholder="Descrição"></textarea>
                                </div>
                                <div class="form-group mb-3">
                                    <input value="${categoria.id}" id="categoriaId" hidden/>
                                    <select class="form-select" aria-label="materia-form" disabled>
                                      <option selected>${categoria.nome}</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-add" onClick="criarMateria()">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
    <div class="mt-3 row cat-container">
        <c:forEach var="materia" items="${materias}">
            <div class="p-3 col-3 h-100">
                <div class="card h-100">
                    <div class="card-header">
                        <p class="card-text">${materia.nome}</p>
                    </div>
                    <div class="card-body">
                        <p class="card-text">${materia.descricao}</p>
                        <a href="/licitacoes/materia/${materia.id}" class="btn btn-primary">Ir</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>