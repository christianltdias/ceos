<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/topMenu.jspf"%>
<script src="<%=request.getContextPath()%>/js/licitacao/licitacaoController.js"></script>

<div class="container-fluid">
    <sec:authorize access="hasAuthority('TAREFA_ADD_CATEGORIA')">
        <div class="act-box mt-3 shadow-sm rounded d-flex justify-content-end">
            <button type="button" class="btn btn-add" data-bs-toggle="modal" data-bs-target="#criaLicitacaoModal">
                Adicionar
            </button>

            <div class="modal fade" id="criaLicitacaoModal" tabindex="-1" aria-labelledby="criaLicitacaoModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalCriarLicitacao">
                            <i class="bi bi-file-earmark-plus text-icon"></i>Adicionar uma nova licitação</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body p-3">
                            <form>
                                <div class="form-group my-3">
                                    <label for="nome" class="mb-3">Nome</label>
                                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome Licitação">
                                </div>
                                <div class="form-group mb-3">
                                    <label for="descricao">Descrição</label>
                                    <textarea class="form-control" id="descricao" name="descricao" rows="3" placeholder="Descrição"></textarea>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="valor">Valor</label>
                                    <input type="number" class="form-control" id="valor" name="valor" placeholder="0.00">
                                </div>
                                <div class="form-group mb-3">
                                    <input value="${materia.id}" id="materiaId" hidden/>
                                    <select class="form-select" aria-label="materia-form" disabled>
                                      <option selected>${materia.nome}</option>
                                    </select>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-add" onClick="criarLicitacao()">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </sec:authorize>
    <div class="mt-3 row cat-container">
        <c:forEach var="licitacao" items="${licitacoes}">
            <div class="p-3 col-3 h-100">
                <div class="card h-100">
                    <div class="card-header">
                        <p class="card-text">${licitacao.professor.nome}</p>
                        <p class="card-text">${licitacao.dataCriacao}</p>
                    </div>
                    <div class="card-body">
                        <p class="card-text">${licitacao.descricao}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>