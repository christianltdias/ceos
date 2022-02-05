<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container-fluid">
    <div class="backdrop">
        <div class="row d-flex flex-row h-100">
            <div class="col-5 bgc-light">
            </div>
            <div class="col-7">
            </div>
        </div>
    </div>
    <div class="form-abs shadow-lg rounded">
        <div class="container h-100">
            <form class="d-flex flex-column justify-content-center" action="/signup">
                <button class="btn-return">
                    <span class="bi bi-arrow-left-short" style="font-size: 2rem; color: white;"></i>
                </button>
            </form>
            <div class="row d-flex flex-row h-100 mt-5">
                <div class="col-12 p-5 mt-5">
                    <form class="h-100 d-flex flex-column justify-content-justify" action="/signup/formulario" method="post">
                        <div class="row">
                            <div class="form-item">
                                <label for="nome" class="form-label">Nome*</label>
                                <input type="text" placeholder="Insira seu nome" name="nome" class="${nome == null ? '' : 'is-invalid'} form-control" id="nome" value="${usuario.nome}"/>
                                <c:if test="${nome != null}"><label for="nome" class="invalid-feedback">Campo obrigatório</label></c:if>
                            </div>
                            <div class="form-item">
                                <label for="sobrenome" class="form-label">Sobrenome</label>
                                <input type="text" placeholder="Insira seu sobrenome" value="${usuario.sobrenome}" name="sobrenome" class="${sobrenome == null ? '' : 'is-invalid'} form-control" id="sobrenome">
                                <c:if test="${sobrenome != null}"><label for="nome" class="invalid-feedback">Campo obrigatório</label></c:if>
                            </div>
                            <div class="form-item">
                                <label for="email" class="form-label">E-mail</label>
                                <input type="email" placeholder="exemplo@dominio.com" value="${usuario.email}" name="email" class="${email == null ? '' : 'is-invalid'} form-control" id="email">
                                <c:if test="${email != null}"><label for="nome" class="invalid-feedback">Campo obrigatório</label></c:if>
                            </div>
                            <div class="form-item">
                                <label for="login" class="form-label">Login</label>
                                <input type="text" placeholder="Insira seu Login" value="${usuario.login}" name="login" class="${login == null ? '' : 'is-invalid'} form-control" id="login">
                                <c:if test="${login != null}"><label for="nome" class="invalid-feedback">Campo obrigatório</label></c:if>
                            </div>
                            <div class="form-item">
                                <label for="senha" class="form-label">Senha</label>
                                <input type="password" placeholder="Insira sua Senha" value="${usuario.senha}" name="senha" class="${senha == null ? '' : 'is-invalid'} form-control" id="senha">
                                <c:if test="${senha != null}"><label for="nome" class="invalid-feedback">Campo obrigatório</label></c:if>
                            </div>
                            <div class="form-item">
                                <label for="confirmaSenha" class="form-label">Confirme sua senha</label>
                                <input type="password" placeholder="Confirme sua Senha" value="${usuario.confirmaSenha}" class="${(confirmaSenha == null && (senhaConfirmada == true || senhaConfirmada == null)) ? '' : 'is-invalid'} form-control" name="confirmaSenha" id="confirmaSenha">
                                <c:choose>
                                    <c:when test="${confirmaSenha != null}">
                                        <label for="confirmaSenha" class="invalid-feedback">A senha deve possuir entre 8 a 20 caracteres</label>
                                    </c:when>
                                    <c:when test="${senhaConfirmada == false}">
                                        <label for="confirmaSenha" class="invalid-feedback">Senhas não são as mesmas</label>
                                    </c:when>
                                </c:choose>
                            </div>
                            <div class="form-item">
                                <label for="classeAcesso" class="form-label">Classe de acesso</label>
                                <select id="classeAcesso" name="classeAcesso" class="form-select" aria-label="Default select example">
                                    <c:forEach var="classe" items="${classes}">
                                        <option value="${classe.nome}" ${usuario.classeAcesso == classe.nome ? 'selected="selected"' : ''}>${classe.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <button type="submit" class="btn btn-outline-primary form-item">Cadastrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>