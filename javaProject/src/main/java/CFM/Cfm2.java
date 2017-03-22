package CFM;

import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import cfm2.CFM;

public class Cfm2 {

	public static void main(String [] arg) throws Exception
	{
		double []netbkt=new double[] {16,16,15,14,13};
		double []netcb=new double[] {4,4,3,2,1};
		double []bkt=new double[] {0, 4 ,6 ,8 ,10};
		double[]obstl=new double[] {0.5,1,1.5};
		CFM cf2=new CFM();
		for(int i=0;i<netbkt.length;i++)
		{
			Object[] result=cf2.cfm2(1,netbkt[i], netcb[i],bkt[i],obstl);
			MWNumericArray temp = (MWNumericArray)result[0];
			double [] weights=(double[])temp.getDoubleData();
		}
	}

}
