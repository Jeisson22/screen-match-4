package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2001);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar",2003);
        otraPelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("El señor de los anillos",2022);
        peliculaDeBruno.evalua(10);
        Serie lost = new Serie("Lost",2000);


        Pelicula p1 = peliculaDeBruno;
        System.out.println("HOLAAAAAAA " + p1.getNombre());


        List<Titulo> lista = new LinkedList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

        for(Titulo ti:lista){
            System.out.println(ti.getNombre());
            if(ti instanceof  Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtista = new ArrayList<>();
        listaDeArtista.add("Penélope Cruz");
        listaDeArtista.add("Antonio Banderas");
        listaDeArtista.add("Ricardo Darin");
        System.out.println(listaDeArtista);

        Collections.sort(listaDeArtista);
        System.out.println("Lista de artistas ordenadas" + listaDeArtista);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha "+ lista);

    }


}
