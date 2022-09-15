

public class Matrix{
	protected int row;
	protected int column;
	protected int [][] mtrx;

	public Matrix(int a, int b ){
		if(row == 0 && column == 0){
			this.row = a;
			this.column = b;
		}
		mtrx = new int[a][b];

	}

	public int getRow(){
		return row;
	}

	public int getColumn(){
		return column;
	}
	
	public int getMtrx(int row, int column) throws MyRunTime{
		if(( row >= this.row) || (column >= mtrx[0].length ) || (row < 0 || column < 0 )){
			throw new MyRunTime("Impossible to get value of these index");
		}
		return mtrx[row][column];
	}
	
	public void setMtrx(int row, int column, int val){
		if(( row >= this.row) || (column >= this.column ) || (row < 0 || column < 0 )){
			throw new MyRunTime("Impossible to set value of these index");
		}
		mtrx[row][column] = val;
	}
	
	public Matrix sum(Matrix a){
		if((this.row != a.row) || (this.column != a.column)){
			throw new MyRunTime("You cannot sum matrixs with diffrent numbers of column or row");
		}
		Matrix time = new Matrix(row, column);
		for( int i = 0; i < this.row; i++){
			for( int j = 0; j < this.column; j++){
				time.mtrx[i][j] = this.getMtrx(i, j) + a.getMtrx(i,j);
			}
		}
		return time;
	}

	public final Matrix product(Matrix a){
		if((this.row != a.column)){
			throw new MyRunTime("You cannot multiply matrixs with diffrent count of rows and columns");
		}
		Matrix time = new Matrix(this.row, a.column);
		int res = 0;
		for( int i = 0; i < this.row; i++){
			for( int j = 0; j < a.column; j++){
				for( int k = 0; k < this.row; k++){
					res += getMtrx(i, k) * a.getMtrx(k,j);
					//System.out.println(i + " " + k + " " + k + " " + j);
					//System.out.println("\n");
				}
				time.mtrx[i][j] = res;
				res = 0;
			}
		}
		return time;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for( int i = 0; i < row; i++){
			for( int j = 0; j < column; j++){
				sb.append(this.getMtrx(i,j));
				sb.append(" ");
			} 
			sb.append("\n");
		}
		return sb.toString();
	}

	public final boolean equals(Matrix a){
		if((row != a.row) || (this.column != a.column)){
			throw new MyRunTime("You cannot compare matrixs with diffrent numbers of column or row");
		}
		for( int i = 0; i < row; i++){
			for( int j = 0; j < column; j++){
				if( this.getMtrx(i,j) != a.getMtrx(i, j) ){
					return false;
				}
			}
		}
		return true;
	}
	
}