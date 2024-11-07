public class CalculadoraRPN {

    public int evaluar(String expresion) {
        Pila pila = new Pila();
        int i = 0;

        while (i < expresion.length()) {
            char caracter = expresion.charAt(i);

            if (caracter == ' ') {
                i++;
                continue;
            }

            // Asumimos que todos los caracteres que no son operadores son dígitos
            if (caracter >= '0' && caracter <= '9') {
                int numero = caracter - '0';
                pila.agregar(numero);
            } else {
                // Realizamos la operación directamente sin verificaciones adicionales
                int numero2 = pila.sacar();
                int numero1 = pila.sacar();
                int resultado = 0;

                if (caracter == '+') {
                    resultado = numero1 + numero2;
                } else if (caracter == '-') {
                    resultado = numero1 - numero2;
                } else if (caracter == '*') {
                    resultado = numero1 * numero2;
                } else if (caracter == '/') {
                    resultado = numero1 / numero2;
                }

                pila.agregar(resultado);
            }

            i++;
        }

        return pila.sacar();
    }
}