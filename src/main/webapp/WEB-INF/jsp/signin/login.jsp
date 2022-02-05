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
    <div class="form-login shadow-lg rounded">
        <div class="container h-100">
            <div class="row d-flex flex-row h-100">
                <div class="col-5 bgc-light d-flex justify-content-center">
                    <form class="d-flex flex-column justify-content-center" action="/signup">
                        <h1 class="form-text-white text-center form-title mb-3">Ceos</h1>
                        <p class="form-text-white text-center form-text mb-5">Crie uma conta</p>
                        <button class="btn btn-outline-primary btn-form-rounded mt-2" type="submit">Cadastre-se</button>
                    </form>
                </div>
                <div class="col-7 p-5">
                    <form class="h-100 d-flex flex-column justify-content-center pb-5" action"@{/signin}" method="post">
                      <div class="mb-5">
                        <label for="username" class="form-label">Usuário</label>
                        <input type="text" placeholder="Insira seu usuário" class="${erro ?'is-invalid' : ''} form-control" id="username" name="username">
                      </div>
                      <div class="mb-5">
                        <label for="senha" class="form-label">Senha</label>
                        <input type="password" placeholder="Insira sua senha" class="${erro ? 'is-invalid' : ''} form-control" id="password" name="password">
                      </div>
                      <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="manterLogado">
                        <label class="form-check-label" for="manterLogado">Manter logado</label>
                      </div>
                      <div class="mt-2 mb-4">
                        <input type="text" class="${erro ?'is-invalid' : ''} form-control" id="erros" name="erros" hidden>
                        <c:if test="${erro}"><label for="erros" class="invalid-feedback">Usuário e/ou senha inválidos</label></c:if>
                      </div>
                      <button type="submit" class="btn btn-outline-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>