package com.alura.screenmatch.principal;

import java.util.*;

public class Tarjeta {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //ArrayList<String> compras = new ArrayList<>();
        Map<String, Integer> compras = new HashMap<>();

        System.out.println("Escriba el límite de la tarjeta:");
        Double limite = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer





        double totalGastado = 0.0;

        while (true) {
            try {
                System.out.println("Escriba la descripción de la compra:");
                String descripcion = scanner.nextLine();

                System.out.println("Escriba el valor de la compra:");
                int valor =   scanner.nextInt();
                scanner.nextLine(); // Limpiar buffe

                // Para agregar la clave y el valor
                compras.put(descripcion,valor);

                totalGastado+=valor;
                if (totalGastado + valor > limite) {
                    System.out.println("¡Límite de la tarjeta excedido! Compra no realizada.");
                }
                System.out.println("Compra realizada!");
                System.out.println("Escriba 0 para salir o 1 para continuar:");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                if (opcion == 0) {
                    break; // Salir del bucle
                }

            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                scanner.nextLine(); // Limpiar entrada errónea
            }
        }

        // Convertir map a listas para ordenar en una lista
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(compras.entrySet());

        // Ordenar por valor (ascendente)
        lista.sort(Map.Entry.comparingByValue());



        // Mostrar las compras registradas
        System.out.println("________________________________________");
        System.out.println("\nCompras registradas:\n");
        for (Map.Entry<String, Integer> compra : lista) {
            System.out.println("Descripción del producto : " + compra.getKey() + " \n" +
                    " Precio del producto :  " + compra.getValue()+ "\n"
                    );
        }

        System.out.println("________________________________________");
        System.out.println("Total de Dinero : S/ " + limite);
        System.out.println("Total gastado: S/ " + totalGastado);
        System.out.println("________________________________________");
        System.out.println("Límite restante: S/ " + (limite - totalGastado));

        scanner.close();
    }
}
