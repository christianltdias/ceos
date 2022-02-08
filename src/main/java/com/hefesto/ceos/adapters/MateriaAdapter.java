package com.hefesto.ceos.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.ceos.model.Materia;

public class MateriaAdapter implements JsonSerializer<Materia> {

    @Override
    public JsonElement serialize(Materia materia, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", materia.getId());
        jsonObject.addProperty("nome", materia.getNome());
        jsonObject.addProperty("descricao", materia.getDescricao());
        jsonObject.addProperty("categoria", materia.getCategoria().getNome());
        return jsonObject;
    }
}
