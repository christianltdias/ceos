package com.hefesto.ceos.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.ceos.model.Permissao;

import java.lang.reflect.Type;

public class PermissaoAdapter implements JsonSerializer<Permissao> {
    @Override
    public JsonElement serialize(Permissao permissao, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", permissao.getId());
        jsonObject.addProperty("nome", permissao.getNome());
        jsonObject.addProperty("descricao", permissao.getDescricao());
        return jsonObject;
    }
}
