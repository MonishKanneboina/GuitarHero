public class GuitarHero { 

   public static void main(String[] args) {
   
        // Create two guitar strings, for concert A and C
      double f = 440;
      double sample = 0;
   
      GuitarString[] a = new GuitarString[37];
      String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'";
      for(int x = 0; x < a.length; x++)
      {
         GuitarString g = new GuitarString(f * Math.pow(1.05956, x - 24));
         a[x] = g;
      }  
   
   
        // the main input loop
      while (true) {
         if (StdDraw.hasNextKeyTyped()) {
            char key = StdDraw.nextKeyTyped();
            if(keyboard.contains(key+""))
            {
               a[keyboard.indexOf(key + "")].pluck();
            }
         } 
         sample = 0;
         for(int i =0; i < a.length; i++)
         {
            sample += a[i].sample();
            a[i].tic();
         }
           
         
         StdAudio.play(sample);
          
      }
   }

}