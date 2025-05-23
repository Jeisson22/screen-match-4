package com.alura.screenmatch.principal;

import java.util.*;

public class Practica {
    public static void main(String[] args) {

        Map<String, Integer> Empleados = new TreeMap<>();
        Empleados.put("Jeisson",22);
        Empleados.put("John",23);
        Empleados.put("Juan",26);
        Empleados.put("Luis",24);
        Empleados.put("Jairo",25);

        System.out.println("Empleados ");
        for(Map.Entry<String, Integer> entry: Empleados.entrySet()){
            System.out.println("ID : " + entry.getKey() + " " + " Valor : " + entry.getValue());
        }



        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("John", 5);
        mapa.put("Alice", 2);
        mapa.put("Bob", 8);
        mapa.put("Diana", 3);

        // Convertir el mapa en una lista de entradas
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapa.entrySet());

        // Ordenar por valor (ascendente)
        lista.sort(Map.Entry.comparingByValue());

        // Mostrar el resultado
        System.out.println("Ordenado por valor (ascendente):");
        for (Map.Entry<String, Integer> entry : lista) {
            System.out.println("ID : " + entry.getKey() + " Valor : " + entry.getValue());
        }

    }
}
