package com.hefesto.ceos.adapters;

import com.google.gson.*;
import com.hefesto.ceos.model.Categoria;
import com.hefesto.ceos.model.Materia;

import java.lang.reflect.Type;

public class CategoriaAdapter implements JsonSerializer<Categoria> {

    @Override
    public JsonElement serialize(Categoria categoria, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", categoria.getId());
        jsonObject.addProperty("nome", categoria.getNome());
        jsonObject.addProperty("descricao", categoria.getDescricao());
        jsonObject.addProperty("urlImagem", categoria.getUrlImagem());
        jsonObject.add("materias", getJsonMaterias(categoria));
        return jsonObject;
    }

    public JsonArray getJsonMaterias(Categoria categoria){
        JsonArray jsonArray = new JsonArray();
        for (Materia materia: categoria.getMaterias()) {
            jsonArray.add(new JsonPrimitive(materia.getNome()));
        }
        return jsonArray;
    }
}
