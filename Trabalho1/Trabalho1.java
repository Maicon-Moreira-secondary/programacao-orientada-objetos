public class Trabalho1 {
    public static void main(String[] args) {
        int[][] matriz1 = { { 2, 3 }, { 4, 5 } };
        mostrarMatrizEmTodasAsOrientacoes(matriz1);

        int[][] matriz2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        mostrarMatrizEmTodasAsOrientacoes(matriz2);

        int[][] matriz3 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        mostrarMatrizEmTodasAsOrientacoes(matriz3);
    }

    public static void mostrarMatrizEmTodasAsOrientacoes(int[][] matriz) {
        System.out.println("\nMatriz original: ");
        mostrarMatriz(matriz);
        if (!ehMatrizQuadrada(matriz)) {
            System.out.println("Matriz nao é quadrada");
            return;
        }
        System.out.println("Matriz rotacionada 90 graus: ");
        mostrarMatriz(rotacionarMatriz(matriz, 90));
        System.out.println("Matriz rotacionada 180 graus: ");
        mostrarMatriz(rotacionarMatriz(matriz, 180));
        System.out.println("Matriz rotacionada 270 graus: ");
        mostrarMatriz(rotacionarMatriz(matriz, 270));
        System.out.println("Matriz rotacionada 360 graus: ");
        mostrarMatriz(rotacionarMatriz(matriz, 360));
    }

    public static boolean ehMatrizQuadrada(int[][] matriz) {
        return matriz.length == matriz[0].length;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotacionarMatriz(int[][] matriz, int graus) {
        int vezesRotacionar90Graus = graus / 90;
        int[][] matrizRotacionada = matriz;
        for (int i = 0; i < vezesRotacionar90Graus; i++) {
            matrizRotacionada = rotacionar90Graus(matrizRotacionada);
        }
        return matrizRotacionada;
    }

    public static int[][] rotacionar90Graus(int[][] matriz) {
        int[][] matrizRotacionada = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matrizRotacionada[i][j] = matriz[matriz.length - j - 1][i];
            }
        }
        return matrizRotacionada;
    }
}
