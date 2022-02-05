package com.hefesto.ceos.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.hefesto.ceos.model.Usuario;

import java.lang.reflect.Type;

public class UsuarioAdapter implements JsonSerializer<Usuario> {

    @Override
    public JsonElement serialize(Usuario usuario, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", usuario.getId());
        jsonObject.addProperty("nome", usuario.getNome());
        jsonObject.addProperty("sobrenome", usuario.getSobrenome());
        jsonObject.addProperty("classeAcesso", usuario.getClasseUsuario().getNome());
        jsonObject.addProperty("email", usuario.getEmail());
        jsonObject.addProperty("ativo", usuario.isAtivo());

        return jsonObject;
    }
}
