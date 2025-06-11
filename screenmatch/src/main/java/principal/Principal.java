package principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.DatosEpisodio;
import model.DatosSerie;
import model.DatosTemporadas;
import service.ConsumoAPI;
import service.ConvierteDatos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1a40f0e2";
    private ConvierteDatos conversor = new ConvierteDatos();



    public void muestraElMenu() throws IOException {


        System.out.println("Por favor escribe el nombre de la serie que deseas buscar");
        // Busca los datos generales de la serie
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);


        System.out.println(datos);


        // Busca los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + "&apikey=1a40f0e2");
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);

        int totalTemporadaSerie = 0;
    // Mostrar solo el titulo de los episodios para las temporadas
//        for (int i = 0; i < datos.totalDeTemporadas() ; i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size() ; j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());
//                con +=1;
//
//            }
//        }

//        System.out.println("Total de episodios de la Serie: " + con);;

        // Existen una funcionalidad lamba para que sea mas legible
        // Expresiones lamba

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        AtomicInteger con = new AtomicInteger(1); temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(con.getAndIncrement() + ". " + e.titulo())));
        System.out.println((con.get() -1));


    }


}

