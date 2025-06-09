package model;

public class Caja<T> {
    private T contenido;

    public T getContenido(){
        return  contenido;
    }
    public void setContenido(T contenido){
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return (String) this.contenido;
    }
}
