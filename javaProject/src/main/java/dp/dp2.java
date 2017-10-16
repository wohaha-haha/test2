package dp;

public class dp2 {
	public static void main(String args[]) {
		int[][] v = { 
				{ 7, 0, 0, 0, 0 },
				{ 3, 8, 0, 0, 0 }, 
				{ 8, 1, 0, 0, 0 }, 
				{ 2, 7, 4, 4, 0 }, 
				{ 4, 5, 2, 6, 5 } };
		int res[][] = new int[v.length][v.length];
		int x[] = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			res[v.length - 1][i] = v[v.length - 1][i];
		}
		for (int i = v.length - 2; i >= 0; i--)
			for (int j = 0; j < i + 1; j++) {
				if (v[i][j] + res[i + 1][j] > v[i][j] + res[i + 1][j + 1]) {
					res[i][j] = v[i][j] + res[i + 1][j];
					x[i] = v[i][j];
				}

				else {
					res[i][j] = v[i][j] + res[i + 1][j + 1];
					x[i] = v[i][j];
				}

			}
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v.length; j++) {
				System.out.print(res[i][j] + "   ");
			}
			System.out.println(x[i] + "   ");
		}

	}

}
