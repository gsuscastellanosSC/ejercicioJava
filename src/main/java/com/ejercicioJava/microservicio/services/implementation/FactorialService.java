package com.ejercicioJava.microservicio.services.implementation;

import com.ejercicioJava.microservicio.services.Factorial;
import org.springframework.stereotype.Service;

import static com.ejercicioJava.microservicio.enums.ErrorMessages.NEGATIVE_NUMBER;

@Service
public class FactorialService implements Factorial {
    @Override
    public long calcularFactorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
        }
        if (numero == 0 || numero == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
