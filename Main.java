
public class Main {

	public static void main(String[] args) {
		BigIntgers x = new BigIntgers("12345");
        BigIntgers y = new BigIntgers(10);
        BigIntgers z;

        z=x.add(y);
        z.print();
        z=x.subtract(y);
        z.print();
        y.setBigInt("100".toCharArray());
        z=x.multiply(y);
        z.print();

	}

}
