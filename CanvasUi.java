import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class CanvasUi extends Canvas {
    static final int N = 4;
    private static final int ROWS = N;
    private static final int COLUMNS = N;
    private static final int SQUARE_SIZE = 50;
    private static final Color LIGHT_SQUARE_COLOR = Color.WHITE;
    private static final Color DARK_SQUARE_COLOR = Color.BLACK;

    private static final Color QUEEN_SQUARE_COLOR = Color.YELLOW;



    private static int[][] a = new int[N][N];
    static List<int[][]> configurations = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chessboard");

        CanvasUi canvas = new CanvasUi();

        frame.add(canvas);

        frame.setSize(N * 60, N * 60);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        //the problem is somewhere here and I cant find it, solveNQueen gives is working I tried it
        // but when I see if we added the array to configurations we see that there is 2 arrays, but they are empty(full of 0)

        UtilityClass.solveNQueen(a, 0, 0);
        //System.out.println(Arrays.deepToString(configurations.get(3)));
        System.out.println("Config Output");

        for (int[][] configuration : configurations) {
            System.out.println(Arrays.deepToString(configuration));
        }
        System.out.println("Number of configurations: " + configurations.size());

        // Update the chessboard display for each of the board configurations
        for (int[][] configuration : configurations) {

            canvas.a = configuration;
            canvas.repaint();
            // Add a delay between updates to allow the user to view each configuration
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawChessboard(g, a);
    }
    private static void drawChessboard(Graphics g, int[][] a) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int x = col * SQUARE_SIZE;
                int y = row * SQUARE_SIZE;

                Color color = ((row + col) % 2 == 0 && a[row][col] == 0) ? LIGHT_SQUARE_COLOR : DARK_SQUARE_COLOR;
                if (a[row][col] == 1) {
                    color = QUEEN_SQUARE_COLOR;
                }
                g.setColor(color);
                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);

            }
        }
    }

}






