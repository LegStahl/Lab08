import java.util.*;
public class Main{

	public static void main(String[] args){
		try{/*
		Matrix a = new Matrix(100, 100);
		Matrix b = new Matrix(100, 100);
		for(int i = 0; i < a.getRow(); i++){
			a.setMtrx((int)(Math.random() * a.getRow() - 1),(int)(Math.random() * a.getRow() - 1),i);
			b.setMtrx((int)(Math.random() * b.getRow() - 1),(int)(Math.random() * b.getRow() - 1),i); 
		}
		Matrix c = new Matrix(100, 100);
		int countThreads = 5;
		int countRowsThreads = a.getRow() / countThreads ;
		int balance = a.getRow() % countThreads;
		int start = 0;
		int end =  countRowsThreads ;
		Thread [] thr = new Thread[countThreads];
		for( int i = 0; i < countThreads; i++ ){
			 if(balance != 0 && (i + 1) == countThreads){
	    		end = end + balance;
	    	}
			thr[i] = new Worker(end, start, a, b, c);
			end = end +  countRowsThreads;
			start = start +  countRowsThreads;
	    }


		long st = System.currentTimeMillis();
		for(int i = 0; i < countThreads; i++){
			thr[i].start();
		}


		for(int i = 0; i < countThreads; i++){
			thr[i].join();
		}
		//Matrix ty = (Matrix)thr[0].Worker.getResult();
		long en = System.currentTimeMillis();
		System.out.println("Time with threads: " + (en - st));
		Matrix d;
		st = System.currentTimeMillis();
		d = a.product(b);
		en = System.currentTimeMillis();
		System.out.println("Time without threads: " + (en - st));
		System.out.println(d.equals(c));
		*/
		
		int [] arr = new int[100000];
		for(int i = 0; i < arr.length;i++){
			arr[i] = (int)(Math.random() * arr.length - 1000);
		}
		System.out.println("" + arr.length);
		FindSearch something = new FindSearch(2, arr);
		long st = System.currentTimeMillis();
		int min = something.job();
		long en = System.currentTimeMillis();
		System.out.println("Time searching with threads: " + (en - st) + " Result: " + min);
		st = System.currentTimeMillis();
		min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		en = System.currentTimeMillis();
		System.out.println("Time searching withount threads: " + (en - st) + " Result: " + min);
		//System.out.println(Arrays.toString(arr));
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}