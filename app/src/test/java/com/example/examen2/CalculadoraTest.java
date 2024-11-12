package com.example.examen2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculadoraTest {

    //Pruebas unitarias del metodo convertir a base seleccionada (Método 1)
    @Test
    public void testConvertirNumero_WithValidBinary() {
        // Prueba con un número binario válido
        String input = "1109"; // 13 en decimal
        int base = 0; // Base binaria
        int resultadoEsperado = 13;

        Assert.assertEquals("El número binario 1101 debería convertirse a 13 en decimal",
                resultadoEsperado, Calculadora.convertirNumero(input, base));
    }

    @Test
    public void testConvertirNumero_WithInvalidHexadecimal() {
        // Prueba con un número hexadecimal inválido
        String input = "1Z3"; // "Z" no es válido en hexadecimal
        int base = 3; // Base hexadecimal
        int resultadoEsperado = -1;

        Assert.assertEquals("El número hexadecimal 1Z3 debería devolver -1 por ser inválido",
                resultadoEsperado, Calculadora.convertirNumero(input, base));
    }

    //Pruebas unitarias del metodo operaciones matematicas (Método 2)
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

    //Pruebas unitarias del metodo para convertir un número decimal a cualquier base (Método 3)
    @Test
    public void testConvertirADestino_WithUnsupportedBase() {
        // Prueba con una base de destino no soportada
        int numeroDecimal = 100;
        int baseDestino = 5; // Base no soportada

        assertThrows("Debería lanzar una excepción para una base no soportada",
                IllegalArgumentException.class, () -> Calculadora.convertirADestino(numeroDecimal, baseDestino));
    }
    @Test
    public void testConvertirADestino() {
        int numeroDecimal = 2017;
        // Prueba conversion a binario
        Assert.assertEquals("11111100001", Calculadora.convertirADestino(numeroDecimal, 0));
        // Prueba conversion a octal
        Assert.assertEquals("3741", Calculadora.convertirADestino(numeroDecimal, 1));
        // Prueba conversion a decimal
        Assert.assertEquals("2017", Calculadora.convertirADestino(numeroDecimal, 2));
        // Prueba conversion a hexadecimal
        Assert.assertEquals("7e1", Calculadora.convertirADestino(numeroDecimal, 3));
    }

    //Pruebas unitarias del metodo encuentra un elemento en una lista (Método 4)
    @Test
    public void testEncuentra_ElementoEnLaLista() {
        // Prueba cuando el elemento está presente en la lista
        List<Integer> lista = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int elemento = 7;

        assertTrue("El elemento 7 debería estar en la lista",
                Calculadora.Encuentra(lista, elemento));
    }

    @Test
    public void testEncuentra_ElementoNoEnLaLista() {
        // Prueba cuando el elemento no está en la lista
        List<Integer> lista = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int elemento = 4;

        assertFalse("El elemento 4 no debería estar en la lista",
                Calculadora.Encuentra(lista, elemento));
    }
    
}
