public class Cat
{
   private int x, y;
   public Cat() {
      x=y=5;
   }
   public void fun() {
      x=7;
   }
   public double go() {
      return x;
   }
   public void back() {
      fun();
   }
   public String toString() {
      return x + " " + y;
   }
}
