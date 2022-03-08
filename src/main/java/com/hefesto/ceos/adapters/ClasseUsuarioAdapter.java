package com.hefesto.ceos.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.ceos.model.ClasseUsuario;

public class ClasseUsuarioAdapter implements JsonSerializer<ClasseUsuario> {

    @Override
    public JsonElement serialize(ClasseUsuario classeUsuario, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", classeUsuario.getId());
        jsonObject.addProperty("nome", classeUsuario.getNome());
        jsonObject.addProperty("descricao", classeUsuario.getDescricao());
        return jsonObject;
    }

}
