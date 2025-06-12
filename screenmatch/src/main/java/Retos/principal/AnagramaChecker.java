package Retos.principal;

public class AnagramaChecker {


        public static boolean sonAnagramas(String palabra1, String palabra2) {
            // Si son exactamente iguales, no son anagramas
            if (palabra1.equalsIgnoreCase(palabra2)) {
                return false;
            }

            // Convertimos ambas palabras a minúsculas y a arreglos de caracteres
            char[] letras1 = palabra1.toLowerCase().toCharArray();
            char[] letras2 = palabra2.toLowerCase().toCharArray();

            // Ordenamos los arreglos
            // claro aca ordenamos para saber si todas las letras estan y verificar que si se pueda combinar si hay una letra diferente sera false
            java.util.Arrays.sort(letras1);
            java.util.Arrays.sort(letras2);


            // Comparamos los arreglos ordenados
            // Claro utilizmos la java.util porque queremos saber un valor booleano
            return java.util.Arrays.equals(letras1, letras2);

        }

        public static void main(String[] args) {
            System.out.println(sonAnagramas("Roma", "Amor")); // true
            System.out.println(sonAnagramas("Hola", "Hola")); // false
            System.out.println(sonAnagramas("Rata", "Tara")); // true
            System.out.println(sonAnagramas("Perro", "Gato")); // false
        }
    }




