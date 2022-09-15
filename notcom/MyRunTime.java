
public class MyRunTime extends RuntimeException{

	private String err;

	public MyRunTime(String a){
		err =  new String();
		err = a;
	}
	
	public String getMessage(){
		return err;
	}
	
}