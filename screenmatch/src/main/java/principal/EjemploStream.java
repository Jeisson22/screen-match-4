package principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStream {
    public void MuestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda", "Luis","Maria Fernanda", "Eric" , "Jeisson");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numerosPares); // Salida: [2, 4, 6, 8, 10]
    }
}
