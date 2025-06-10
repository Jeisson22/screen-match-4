package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DatosSerie;

import java.util.Objects;

public class ConvierteDatos implements  IConvierteDatos{
    private ObjectMapper objectMapper = new ObjectMapper();

    // La T es para ingresar cualquier tipo de dato OSE GENERICO ya sea clase, objectm, etc
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
