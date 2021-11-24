public class Puzzle {
    private static String[] words = {"TEST", "WATER", "DOG"}; //Important
    private String word; //Important
    private String underline;
    private String guesses; 
    private int count;
    
    //The reason why these two are instance variables has more to do with scope than representation of attributes as they are used in multiple methodes.
    private boolean twoLetter;
    private boolean isThere;
    
    public Puzzle (){
        //String Initialization
        word  = words [(int)(Math.random() * 3)];
        underline = "";
        guesses = "";
        //Int Initialization
        count = 0;
        //Boolean Initialization
        twoLetter = false;
        isThere = false;
        //Formation Of Puzzle
        for (int i = 0; i < word.length(); i++){
            underline += "_";
        }
    }
    
    public boolean makeGuess(String guess) {
        guess = guess.toUpperCase();
        //Tracking Variable
        int prev = count;
        if (guess.length()>1) {
            twoLetter = true;
        } else if (alreadyUsed(guess)) {
            twoLetter = false;
            isThere = true;
            return true;
        } else {
            twoLetter = false;
            isThere = false;
            guesses += guess + ", ";
            for (int i=0; i< word.length(); i++){
                if ((word.substring(i,i+1)).equals(guess)) {
                    count++;
                    display(i,guess);
                }   
            }
        } 
        if (twoLetter == true) {
            return true;
        } else if (prev == count) {
            return false;
        }  
        return true; 
    }
    
    public boolean isUnsolved() {
        if (count==word.length()) {
            return false;
        }
        return true;
    }
    
    public void display(int index,String str){
        if (count>0){
            underline = underline.substring(0,index) + str + underline.substring(index + 1) ;
        }
    }
    
    public void show(){
        if (twoLetter == false && isThere == false) {
           System.out.print("\n\nPuzzle: " + underline + "\n");
           System.out.print("\nGuesses: " + guesses); 
        } else if (twoLetter == true) {
           System.out.print("\n\nPuzzle: " + underline + "\n");
           System.out.print("\nGuesses: Please Enter Only ONE Letter!"); 
        } else if (isThere == true) {
           System.out.print("\n\nPuzzle: " + underline + "\n");
           System.out.print("\nGuesses: Please Enter A Different Letter!"); 
        }
    }
    
    private boolean alreadyUsed (String str){
        for (int i=0; i< guesses.length(); i++){
            if ((guesses.substring(i,i+1)).equals(str)) {
                return true;
            }   
        }
        return false;
    }
    
    public String getWord(){
        return word;
    }
}
