

public class fibwith2variables {

	public static void main(String[] args) {
		int n=10,a=0,b=1;
		while(n-->0) {
			System.out.print(a+", ");
			b=a+b;
			a=b-a;
		}

	}

}
