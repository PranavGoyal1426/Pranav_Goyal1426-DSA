public class Main {

    static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {

        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;

        if (image[r][c] != oldColor)
            return;

        image[r][c] = newColor;

        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];

        if (oldColor == color)
            return image;

        dfs(image, sr, sc, oldColor, color);

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int sr = 1, sc = 1, color = 2;

        image = floodFill(image, sr, sc, color);

        for (int[] row : image) {
            for (int pixel : row)
                System.out.print(pixel + " ");
            System.out.println();
        }
    }
}