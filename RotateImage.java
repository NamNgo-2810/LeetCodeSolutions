class RotateImage {
    // Problem 48: Rotate Image
    int[][] image;
    public void rowHandling(int i) {
        for (int j = i; j < image.length - i - 1; j++) {
            swap4Corner(i, j, image.length - 1);
        }
    }
    public void swap4Corner(int i, int j, int l) {
        int temp1 = image[i][j];
        int temp2 = image[j][l-i];
        int temp3 = image[l-i][l-j];
        int temp4 = image[l-j][i];
        image[j][l-i] = temp1;
        image[l-i][l-j] = temp2;
        image[l-j][i] = temp3;
        image[i][j] = temp4;
    }
    public void rotate(int[][] matrix) {
        image = matrix;
        int n = matrix.length;
        int i = 0;
        while (i < n/2) {
            rowHandling(i);
            i++;
        }

    }
}
