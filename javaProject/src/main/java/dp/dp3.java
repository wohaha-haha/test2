package dp;

public class dp3 {
	public static void main(String args[]) 
	{
		int v[]={0,6,3,5,4,6};
		int w[]={0,2,2,6,5,4};
		int c=11;
		int f[][]=new int[v.length][c];
		
		for(int j=0;j<c;j++) 
		{
			if((f[v.length-1][j]<v[v.length-1])&&(j>w[v.length-1])) 
			{
				f[v.length-1][j]=v[v.length-1];
			}
				
		}
		for(int i=0;i<v.length;i++) 
		{
			for(int j=0;j<c;j++)
				System.out.print(f[i][j]+"    ");
			System.out.println("");
			
		}
			
//		for(int i=v.length-2;i>=0;i--) 
//		{
//			for(int j=0;j<w.length;j++) 
//			{
//				if(f[i][j]<v[i]&&((j+w[i])<c))
//					f[i][j]=v[i];
//			}
//		}
	}

}
