package dp;

public class dp1 {

	static int c = 10; // 背包的容量
	static int w[] = { 0, 2, 2, 6, 5, 4 };// 物品的重量，其中0号位置不使用 。
	static int v[] = { 0, 6, 3, 5, 4, 6 };// 物品对应的待加，0号位置置为空。
	static int n = 5; // n为物品的个数
	static int x[] = new int[n + 1];

	static void package0_1(int m[][], int w[], int v[], int n)// n代表物品的个数
	{
		// 采用从底到顶的顺序来设置m[i][j]的值
		// 首先放w[n]
		for (int j = 0; j <= c; j++)
			if (j < w[n])
				m[n][j] = 0; // j小于w[n],所对应的值设为0，否则就为可以放置
			else
				m[n][j] = v[n];

		// 对剩下的n-1个物品进行放置。
		int i;
		for (i = n - 1; i >= 1; i--)
			for (int j = 0; j <= c; j++)
				if (j < w[i])
					m[i][j] = m[i + 1][j];// 如果j < w[i]则，当前位置就不能放置，它等于上一个位置的值。
											// 否则，就比较到底是放置之后的值大，还是不放置的值大，选择其中较大者。
				else
					m[i][j] = m[i + 1][j] > m[i + 1][j - w[i]] + v[i] ? m[i + 1][j] : m[i + 1][j - w[i]] + v[i];
	}

	static void answer(int m[][], int n) {
		int j = c;
		int i;
		for (i = 1; i <= n - 1; i++)
			if (m[i][j] == m[i + 1][j])
				x[i] = 0;
			else {
				x[i] = 1;
				j = j - w[i];
			}
		x[n] = m[i][j] != 0 ? 1 : 0;
	}

	public static void main(String arg[]) {
		int m[][] = new int[6][11];

		package0_1(m, w, v, n);
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 10; j++)
				System.out.print(m[i][j] + "  ");
			System.out.println("  ");
			// cout << endl;
		}
		answer(m, n);
		// cout << "The best answer is:\n";
		for (int i = 1; i <= 5; i++)
			System.out.print(x[i] + "  ");
		// cout << x[i] << " ";
		// system("pause");
		// return 0;
	}
}
