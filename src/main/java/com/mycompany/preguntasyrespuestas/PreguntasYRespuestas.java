/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preguntasyrespuestas;

/**
 *
 * @author mayam
 */
import java.util.Scanner;
import java.util.Random;

public class PreguntasYRespuestas {
    public static void main(String[] args) {
        // Array de preguntas y respuestas
        String[][] preguntasRespuestas = {
                {"¿Cuál es la capital de Francia?", "París"},
                {"¿En qué año comenzó la Segunda Guerra Mundial?", "1939"},
                {"¿Quién escribió 'Cien años de soledad'?", "Gabriel García Márquez"},
                {"¿Cuál es el planeta más grande del sistema solar?", "Júpiter"},
                {"¿Cuál es el río más largo del mundo?", "Amazonas"},
                {"¿En qué año se fundó Microsoft?", "1975"},
                {"¿Cuál es el componente principal del aire?", "Nitrógeno"},
                {"¿Quién pintó la Mona Lisa?", "Leonardo da Vinci"},
                {"¿Cuál es el animal terrestre más grande?", "Elefante"},
                {"¿Cuántos continentes hay en el mundo?", "7"}
               
        };

        // Mezclar las preguntas de forma aleatoria
        mezclarPreguntas(preguntasRespuestas);

        // Iniciar el juego
        jugar(preguntasRespuestas);
    }

    // Método para mezclar las preguntas utilizando el algoritmo de Fisher-Yates
    private static void mezclarPreguntas(String[][] preguntasRespuestas) {
        Random rand = new Random();
        for (int i = preguntasRespuestas.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);

            // Intercambiar preguntas y respuestas
            String[] temp = preguntasRespuestas[i];
            preguntasRespuestas[i] = preguntasRespuestas[index];
            preguntasRespuestas[index] = temp;
        }
    }

    // Método principal del juego
    private static void jugar(String[][] preguntasRespuestas) {
        Scanner scanner = new Scanner(System.in);
        int puntaje = 0;

        System.out.println("¡Bienvenido al juego de preguntas y respuestas!");

        // Iterar sobre cada pregunta
        for (int i = 0; i < preguntasRespuestas.length; i++) {
            String pregunta = preguntasRespuestas[i][0];
            String respuestaCorrecta = preguntasRespuestas[i][1];

            // Presentar la pregunta al usuario
            System.out.println("\nPregunta " + (i + 1) + ": " + pregunta);
            System.out.print("Tu respuesta: ");

            // Obtener la respuesta del usuario
            String respuestaUsuario = scanner.nextLine();

            // Verificar si la respuesta es correcta
            if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) {
                System.out.println("¡Correcto! +1 punto\n");
                puntaje++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + respuestaCorrecta + "\n");
            }
        }

        // Mostrar el puntaje final
        System.out.println("¡Fin del juego! Tu puntaje final es: " + puntaje);
    }
}

