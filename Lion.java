public class Lion extends Cat
{
   private int x;
   public Lion() {
      x=9;
   }
   public void fun() {
      x=3;
   }
   public void fun1() {
	   System.out.println("hi");
   }
   public double go() {
      return x;
   }
   public void back() {
      super.back();
   }
   public String toString() {
      return super.toString() + " " + x;
   }
}
