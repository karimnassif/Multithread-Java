public class mt extends Thread {

   int x;
   int y;
   String[][] section;
   String[] words;


   public mt(int x, int y, String[][] section, String[] words){
       this.x= x;
       this.y=y;
       this.section=section;
       this.words = words;
   }

   public void run(){
       String test = "";
       for(int i=0; i<5; i++){
           for(int j=0; j<5; j++){
               test = test + section[i][j];
           }
           for(String word: words){
               if(word.equals(test)){
                   System.out.print(test + " : ");
                   System.out.println("Horizontal at " + y + ", " + (i+x));
               }
           }
           test = "";
       }
       test = "";
       for(int i=0; i<5; i++){
           for(int j=0; j<5; j++){
               test = test + section[j][i];
           }
           for(String word: words){
               if(word.equals(test)){
                   System.out.print(test + " : ");
                   System.out.println("Vertical at " + (i + y) + ", " + x);
               }
           }
           test = "";
       }
   }


   public static void main(String[] args) {
       String[][] total = {{"t", "c", "l", "a", "s", "q", "u"},
                           {"r", "l", "e", "t", "t", "u", "s"},
                           {"e", "a", "t", "r", "e", "e", "s"},
                           {"e", "s", "k", "a", "t", "u", "t"},
                           {"c", "s", "q", "u", "a", "e", "a"},
                           {"a", "r", "r", "a", "y", "m", "c"},
                           {"c", "r", "s", "q", "y", "v", "k"}};
       String[][] input = new String[5][5];
       String[] words = {"array", "class", "queue", "stack", "trees"};
       for(int i=0;i<3;i++){
           for(int j = 0; j<3; j++){
               for(int x = 0; x<5; x++){
                   for(int y = 0; y<5; y++){
                       input[x][y] = total[x+i][y+j];
                   }
               }

               Thread t = new mt(i, j, input, words);
               t.run();
           }
       }
   }
}

