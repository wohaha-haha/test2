package pt;

import com.mathworks.toolbox.javabuilder.MWNumericArray;

import protect1.Protect1;


public class Pt1 {
	public static void main(String [] arg) throws Exception
	{
		double []mean=new double[] {19,27.5,13.7,8.2};
		double []sigma=new double[] {8.1,14.8,7.1,7.5};
		double cap=107;
		double[]fare=new double[] {105,83,57,39};
		Protect1 pt1=new Protect1();
		Object[] result=pt1.protect1(1,fare, mean,sigma,cap);
		MWNumericArray temp = (MWNumericArray)result[0];
		double [] weights=(double[])temp.getDoubleData();
		for(int i=0;i<weights.length;i++)
			System.out.println(weights[i]);
	}

}
