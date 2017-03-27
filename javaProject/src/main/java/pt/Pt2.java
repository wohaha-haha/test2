package pt;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import protect1.Protect1;
import protect2.pt2;

public class Pt2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		double []mean=new double[] {19,27.5,13.7,8.2};
		double []sigma=new double[] {8.1,14.8,7.1,7.5};
		double cap=107;
		double[]fare=new double[] {105,83,57,39};
		double[]book=new double[]{1,9,5,18};
		pt2 pt2=new pt2();
		Object[] result=pt2.protect2(1,fare, mean,sigma,book,cap);
		MWNumericArray temp = (MWNumericArray)result[0];
		double [] weights=(double[])temp.getDoubleData();
		for(int i=0;i<weights.length;i++)
			System.out.println(weights[i]);
	}

}
