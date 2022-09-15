public class Worker extends Thread{
	private int rowMax;
	private int rowMin;
	Matrix time1;
	Matrix time2;
	Matrix result;
	public Worker(int rMax, int rMin, Matrix a, Matrix b, Matrix c){
		rowMax = rMax;
		rowMin = rMin;
		time1 = a;
		time2 = b;
		result = c;
	}

	public void run(){
		int res = 0;
		for( int i = rowMin; i < time1.getRow(); i++){
			for( int j = 0; j < time2.getColumn(); j++){
				for( int k = 0; k < time1.getRow(); k++){
					res += time1.getMtrx(i, k) * time2.getMtrx(k,j);
				}
				if(i < rowMax){
					result.setMtrx(i,j,res);
					res = 0;
				}
				else{
					return;
				}
			}
		}
		//this.getResult();
	}
	public Matrix getResult(){
		System.out.println(result);
		return (Matrix) result;
	}
}