package com.hefesto.ceos.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.ceos.model.Licitacao;
import com.hefesto.ceos.utils.GeradorDeDatas;

import java.lang.reflect.Type;

public class LicitacaoAdapter implements JsonSerializer<Licitacao> {

    @Override
    public JsonElement serialize(Licitacao licitacao, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id",licitacao.getId());
        jsonObject.addProperty("professor",licitacao.getProfessor().getId());
        jsonObject.addProperty("materia",licitacao.getMateria().getNome());
        jsonObject.addProperty("dataCriacao", GeradorDeDatas.getInstance().dataFormatada(licitacao.getDataCriacao()));
        jsonObject.addProperty("ativo",licitacao.isAtivo());
        jsonObject.addProperty("valor",licitacao.getValor());
        jsonObject.addProperty("descricao",licitacao.getDescricao());
        return jsonObject;
    }

}
