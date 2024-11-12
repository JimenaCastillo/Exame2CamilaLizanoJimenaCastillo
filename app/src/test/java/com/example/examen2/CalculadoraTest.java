package com.example.examen2;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    //Pruebas unitarias del metodo convertir a base seleccionada
    @Test
    public void testConvertirNumeroBinario() {
        // Prueba para un número binario
        String input = "1010"; // En binario, esto es 10 en decimal
        int resultado = Calculadora.convertirNumero(input, 0);
        assertEquals(10, resultado, "El número binario 1010 debería convertirse a 10 en decimal");
    }

    @Test
    public void testConvertirNumeroHexadecimal() {
        // Prueba para un número hexadecimal
        String input = "A"; // En hexadecimal, esto es 10 en decimal
        int resultado = Calculadora.convertirNumero(input, 3);
        assertEquals(10, resultado, "El número hexadecimal A debería convertirse a 10 en decimal");
    }

    //Pruebas unitarias del metodo operaciones matematicas
    @Test
    void testSuma() {
        int resultado = Calculadora.realizarOperacion(5, 10, "+");
        assertEquals(15, resultado, "La suma de 5 y 10 debería ser 15");
    }

    @Test
    void testDivisionPorCero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculadora.realizarOperacion(10, 0, "/");
        });
        assertEquals("División por 0", exception.getMessage(), "Debe lanzar una excepción al dividir por 0");
    }
    
}
