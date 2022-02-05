<%@ include file="/WEB-INF/jspf/header.jspf"%>
<%@ include file="/WEB-INF/jspf/topMenu.jspf"%>
<script src="<%=request.getContextPath()%>/js/categoria/categoriaController.js"></script>
<div class="container-fluid">
    <div class="act-box mt-3 shadow-sm rounded">
        <h1>Hello World!</h1>
    </div>
    <div class="mt-3 row cat-container">
        <div class="p-3 col-3 h-100">
            <div class="card h-100">
                <img src="${categoria.urlImagem}" class="card-img-top" alt="${categoria.nome}">
                <div class="card-header">
                    <p class="card-text">${categoria.nome}</p>
                </div>
                <div class="card-body">
                    <p class="card-text">${categoria.descricao}</p>
                    <button><a href="/categorias/${categoria.id}">Ir</a></button>
                </div>
            </div>
        </div>
    </div>
</div>