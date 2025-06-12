package Retos.principal;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzz_1 {


    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private static final String FIZZBUZZ = "fizzbuzz";

    // Vamos a crear un limite
    private final int  limite;


    public FizzBuzz_1(int limite) {
        this.limite = limite;
    }

    public void ejecutar(){
        int contador = 0;

        for(int i=1; i <= limite; i++){
            String resultado = obtenerResultado(i);
            if(!resultado.isEmpty()){
                System.out.println(resultado);
            }
            if(esMultiploDeTres(i)){
                contador ++;
            }
        }
        System.out.println("Total múltiplos de 3 (incluyendo fizzbuzz): " + contador);
    }

    private String obtenerResultado(int numero){
        boolean multiploDe3 = esMultiploDeTres(numero);
        boolean multiploDe5 = esMultiploDeCinco(numero);
        if(multiploDe3 && multiploDe5) return FIZZBUZZ;
        if(multiploDe3) return  FIZZ;
        if(multiploDe5) return BUZZ;

        return "";
    }

    private boolean esMultiploDeTres(int numero){
        return  numero%3 ==0;
    }

    private boolean esMultiploDeCinco(int numero){
        return numero%5 == 0;
    }



}
