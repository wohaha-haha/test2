package CFM;

import java.util.HashMap;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import odN1.OdN1;

public class Od1 {
	public static void main(String [] arg) throws MWException
	{
		String seg[]={"CCCDDD","AAACCC","AAABBB","BBBCCC","BBBDDD","AAADDD"};
//		String seg[]={"AAACCC","AAADDD","BBBCCC","BBBEEE","CCCDDD","CCCEEE"};
		String tmpSeg[]=seg;
		int gra[][]=null;
		int segCount=0;
		HashMap<String, Integer> legMap=new HashMap<String,Integer>();
		String s=null;
		String e=null;
		for(int i=0;i<seg.length;i++)
		{
			s=seg[i].substring(0, 3);
			e=seg[i].substring(3);
			if(!legMap.containsKey(s))
				legMap.put(s, segCount++);
			if(!legMap.containsKey(e))
				legMap.put(e, segCount++);
		}
		gra=new int[legMap.keySet().size()][legMap.keySet().size()];
		for(int i=0;i<seg.length;i++)
		{
			s=seg[i].substring(0, 3);
			e=seg[i].substring(3);
			gra[legMap.get(s)][legMap.get(e)]=1;
		}
		int count=0;
		int m=0;
		int n=0;
		while(true)
		{
			
			for(m=count,segCount=count;m<gra.length;m++)
			{
				if(gra[m][n]==1)
				{
					int tmpC=0;
					int tmp[]=gra[m];
					gra[m]=gra[count];
					gra[count]=tmp;
					for(int x=0;x<gra.length;x++)
					{
						tmpC=gra[x][m];
						gra[x][m]=gra[x][count];
						gra[x][count]=tmpC;
					}
					for(String key:legMap.keySet())
					{
						if(legMap.get(key)==m)
							s=key;
						if(legMap.get(key)==count)
							e=key;
					}
					tmpC=legMap.get(s);
					legMap.put(s, legMap.get(e));
					legMap.put(e, tmpC);
					count++;
				}
			}
			if(segCount-count==0)
			{
				n++;
				count++;
				if(n==gra.length)
					break;
			}
			else
				{
				n=0;
				count=0;
				}
			
		}
		count=1;
		for(m=0;m<gra.length;m++)
		{
			for(n=m;n<gra.length;n++)
			{
				if(gra[m][n]==1)
				{
					
					for(String key:legMap.keySet())
					{
						if(legMap.get(key)==m)
							s=key;
						if(legMap.get(key)==n)
							e=key;
					}
					tmpSeg[count-1]=s+e;
					gra[m][n]=count++;
				}
					
			}
		}
		double cap=90;
		double [][]fare={
				{216,203 ,194 ,152},
				{519 ,344 ,262 ,231},
				{582, 379 ,302, 269},
				{440, 315, 223, 197},
				{485, 340 ,247, 209},
				{251, 179, 164 ,134}
		};
		double[][]mean={
				{25, 3 ,7 ,26},
		    {2,1,4,14},
		   {3,1,4,2},
		    {10,22,12,33},
		    {6,4,5,6},
		    {19,56,7,6}};
		double [][]sigma={
				{7,2.25,5,11.5},
		    {1.5,2,3.25,6.75},
		    {2.5,1.5,2.5,2.5},
		   {5,8.5,6.75,12.5},
		    {4,2.75,2.25,4.75},
		    {5,20.25,5.5,3.25}
		    };
		OdN1 od=new OdN1();
		Object[] result;
		Integer[][]a = null;
		result=od.odN1(1, cap,fare,mean,sigma,gra);
		MWNumericArray temp = (MWNumericArray)result[0];
		float [][] weights=(float[][])temp.toFloatArray();
		System.out.println(weights[0][0]);
	}

}
