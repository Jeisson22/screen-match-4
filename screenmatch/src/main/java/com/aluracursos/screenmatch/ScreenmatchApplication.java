package com.aluracursos.screenmatch;

import model.Caja;
import model.DatosEpisodio;
import model.DatosSerie;
import model.DatosTemporadas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import principal.EjemploStream;
import principal.Principal;
import service.ConsumoAPI;
import service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var consumoApi = new ConsumoAPI();
//		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&apikey=1a40f0e2");
//		//var json = consumoApi.obtenerDatos("https://dragonball-api.com/api/characters/2");
//		System.out.println(json);
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//
//
//		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&Season=1&Episode=1&apikey=1a40f0e2");
//		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
//		System.out.println(episodios);
//
//		List<DatosTemporadas> temporadas = new ArrayList<>();
//		for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
//				json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game&Season="+ i +"&apikey=1a40f0e2");
//				var datosTemporadas = conversor.obtenerDatos(json,DatosTemporadas.class);
//				temporadas.add(datosTemporadas)
//		;
//		}
//		temporadas.forEach(System.out::println);

//		Principal principal = new Principal();
//		principal.muestraElMenu();

		EjemploStream ejemploStream = new EjemploStream();
		ejemploStream.MuestraEjemplo();




	}
}
