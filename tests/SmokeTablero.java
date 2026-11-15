import buscaminasutn.*;

public class SmokeTablero {
    public static void main(String[] args) {
        for (int size = 2; size <= 12; size++) {
            Tablero tablero = new Tablero(size);
            Casilla[][] cells = tablero.getCasillas();
            int mines = 0;
            for (int row = 0; row < size; row++) for (int col = 0; col < size; col++) {
                if (cells[row][col].isEsMina()) mines++;
                int adjacent = 0;
                for (int i = Math.max(0,row-1); i <= Math.min(size-1,row+1); i++)
                    for (int j = Math.max(0,col-1); j <= Math.min(size-1,col+1); j++)
                        if ((i != row || j != col) && cells[i][j].isEsMina()) adjacent++;
                if (cells[row][col].getMinasAdyacentes() != adjacent) throw new AssertionError("adyacencias");
            }
            if (mines != 2 * size) throw new AssertionError("número de minas");
            tablero.marcarCasilla(0,0);
            if (!cells[0][0].isEstaMarcada()) throw new AssertionError("marcar");
            tablero.marcarCasilla(0,0);
            if (cells[0][0].isEstaMarcada()) throw new AssertionError("desmarcar");
        }
        try { new Tablero(1); throw new AssertionError("tamaño inválido"); }
        catch (IllegalArgumentException esperado) { }
        System.out.println("PASS: minas, adyacencias y marcado en tamaños 2 a 12; rechazo de tamaño 1");
    }
}
