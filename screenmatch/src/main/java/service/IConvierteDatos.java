package service;

public interface IConvierteDatos {
    // T T ES PARA TRABAJAR CON TIPOS DE DATOS GENERICOS
    <T> T obtenerDatos(String json, Class<T> clase);
}
