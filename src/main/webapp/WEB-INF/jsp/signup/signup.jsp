<%@ include file="/WEB-INF/jspf/header.jspf"%>
<div class="container-fluid">
    <div class="backdrop">
        <div class="row d-flex flex-row h-100">
            <div class="col-5 bgc-light">
            </div>
            <div class="col-7">
            </div>
        </div>
        <div class="form-signup shadow-lg rounded">
            <div class="container h-100">
                <div class="row d-flex flex-row h-100">
                    <div class="col-5 bgc-light d-flex justify-content-center">
                        <div class="d-flex flex-column justify-content-center">
                            <form class="d-flex flex-column justify-content-center" action="/signin">
                                <h1 class="form-text-white text-center form-title mb-3">Ceos</h1>
                                <p class="form-text-white text-center form-text mb-5">Já possui uma conta?</p>
                                <button class="btn btn-outline-primary btn-form-rounded mt-2">Login</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-7 p-5">
                        <form class="h-100 d-flex flex-column justify-content-center pb-5" action="/signup/formulario">
                            <div>
                                <div class="row mb-5">
                                    <button class="btn-soc col-4"><i class="bi bi-facebook" style="font-size: 2rem; color: cornflowerblue;"></i></button>
                                    <button class="btn-soc col-4"><i class="bi bi-google" style="font-size: 2rem; color: cornflowerblue;"></i></button>
                                    <button class="btn-soc col-4"><i class="bi bi-linkedin" style="font-size: 2rem; color: cornflowerblue;"></i></button>
                                </div>
                                <div class="row mb-3">
                                    <label for="email" class="form-label">E-mail</label>
                                    <input type="email" placeholder="Insira sua E-mail" class="form-control" id="email">
                                </div>
                                <button type="submit" class="btn btn-outline-primary w-100 mt-5">Cadastrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>