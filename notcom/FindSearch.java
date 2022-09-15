public class FindSearch{
	public class Find extends Thread{
		private int end;
		private int start;
		private int [] array;
		public int number;

		public Find(int st,int en, int[] arr, int num){
			end = en;
			start = st;
			array = arr;
			number = num;
		}

		public void run(){
			int min = array[start];
			for(int i = start; i < end; i++){
				if(array[i] < min){
					min = array[i];
				}
			}
			res[number] = min;
		}
	}
	private Thread []thr;
	public int [] res;
	private int amount;
	public FindSearch(int amountThreads, int [] arr){
		amount = amountThreads;
		thr = new Find[amountThreads];
		res = new int[amount];
		int balance = arr.length % amountThreads;
		int count = arr.length / amountThreads;
		int st = 0;
		int en = count;
		for(int i = 0; i < amountThreads; i++ ){
			if((balance != 0) && (i + 1) == amountThreads){
				en = en + balance;
			}
			thr[i] = new Find(st, en, arr, i);
			en = en + count;
			st = st + count;
		}
	}


	public int job(){
		try{
		for(int i = 0; i < amount; i ++ ){
				thr[i].start();
		}
		//int min2 = thr[0].getResult();
		for(int i = 0; i < amount; i ++ ){
				thr[i].join();
		}
		int min = res[0];
		for(int i = 0; i < amount; i++){
			if(res[i] < min){
				min = res[i];
			}
		}
		return min;
	}catch(Exception e){
			System.out.println(e.getMessage());
			return 0;
	}

	}
}
