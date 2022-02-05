package com.hefesto.ceos.adapters;

import com.google.gson.*;
import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.ClasseUsuario;
import com.hefesto.ceos.model.Materia;

import java.lang.reflect.Type;

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
