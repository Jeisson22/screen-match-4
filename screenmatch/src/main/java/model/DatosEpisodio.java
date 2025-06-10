package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Episode")Integer numeroEpisodio,
        @JsonAlias("imdbRating")String evaluacion,
       @JsonAlias("Released")String fechaDeLanzamiento


    )
{

    public int numeroEpisodioComoEntero() {
        try {
            return Integer.parseInt(String.valueOf(numeroEpisodio));
        } catch (NumberFormatException e) {
            return 0; // en caso de "N/A" u otro error
        }

}


}
