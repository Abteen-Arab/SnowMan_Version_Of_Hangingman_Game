public class HangingMan {
    private int health;
    private String[] snowdude = {"   _|==|_\n    (^^)\n>--(`^^')--<\n  (`^'^'`)\n  `======'", 
                                "    (••)\n>--(`^^')--<\n  (`^'^'`)\n  `======'", 
                                "    (••)\n   (`^^')--<\n  (`^'^'`)\n  `======'",
                                "    (••)\n   (`^^')   \n  (`^'^'`)\n  `======'",
                                "\n   (`^^')   \n  (`^'^'`)\n  `======'       (••)",
                                "\n   \n  (`^'^'`)\n  `======'       ( •)",
                                "\n\n   \n  `======'       ( •)",
                                "\n\n   \n  `======' ",
                                "\n\n   \n  `======' "};

    public HangingMan() {
        health = 0; 
    }
    public void dieSomeMore() {
        health++;
    }
    public boolean isntDead() {
        if (health < 8) {
            return true;
        } 
        return false;
    }
    public void show(){
       int index = 0;
       if (health < 9){
           index = health;
       }
       System.out.print(snowdude[index]);
    }
}
