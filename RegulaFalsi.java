import java.text.*;
class RegulaFalsi 
{
   static double doFunction(double x)
   {
      return ((x*x*x)-(4*x)-9);
   }

   static void doFalsePosition(double x0, double x1)
   {

      int iterNum = 1;    /* how many times RegulaFalsi has been performed */
      double f0, f1, f2;  /* function values */
      double x2;          /* new point for function evaluation */
      /* to print numbers with 8 digits behind the decimal point */
      DecimalFormat df = new DecimalFormat("0.00000000");
      double tolerance = 0.0000001;   /* smallest possible interval
                                        width to search */
      int maxIterations =100;  /* the maximum number of times to do
                                  the false position method */

      System.out.println("Iteration #\tX0\t\tX1\t\tX2\t\tF(X2)"); // \t is a tab


      do 
      {
         f0 = doFunction(x0);
         f1 = doFunction(x1);
         x2 = x1 - f1 * (x0 - x1) / (f0 - f1);
         f2 = doFunction(x2);
         System.out.println(iterNum + "\t\t" + df.format(x0) + "\t" +
	                    df.format(x1) + "\t" + df.format(x2) + "\t" +
   	     df.format(f2));
         if ((f2 > 0 && f0 < 0) || (f2 < 0 && f0 > 0)) 
         {
        	 x1 = x2;
         }
         else
         {
        	 x0 = x2;
         }
         iterNum++;        
      } while (Math.abs(f2) >= tolerance && iterNum <= maxIterations);
      System.out.println("Root is: "+x0);
   }         

   public static void main(String[] args)
   {
      doFalsePosition(1, 0);
   }
}
