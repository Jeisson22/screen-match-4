package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2001);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar",2003);
        otraPelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("El señor de los anillos",2022);
        peliculaDeBruno.evalua(10);
        Serie lost = new Serie("Lost",2000);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

        for(Titulo ti:lista){
            System.out.println(ti);
            Pelicula pelicula = (Pelicula) ti;
            System.out.println(pelicula.getClasificacion());
        }

    }


}
