package principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.DatosEpisodio;
import model.DatosSerie;
import model.DatosTemporadas;
import model.Episodio;
import service.ConsumoAPI;
import service.ConvierteDatos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        AtomicInteger con = new AtomicInteger(1);
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(con.getAndIncrement() + ". " + e.titulo())));
        System.out.println((con.get() - 1));

        // Convertir todas las informaciones a una lista del tipo datoEpisodios

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        // Top 5 episodios
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(5)
                .forEach(System.out::println);


        // Convirtiendo los datos a una lista de tipo episodios
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        // Busqueda de episodios a partir de x año

        System.out.println("Por favor indica el año a partir del cual deseas ver los episodios");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() +
                                "Episodio " + e.getTitulo() +
                                "Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)
                ));


    }

}

