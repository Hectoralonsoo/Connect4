package Model;

public class Token {
   private Color color;
    Token(Color color){
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public Token copy(){
        Token copia = new Token(this.color);
        return copia;
    }

    public String write(){

        String string = this.color.toString();

        if(this.isNull()){
            string = "⬛";
        }else if(this.isYellow()){
            string = "\uD83D\uDFE8";
        }else if(this.isRed()){
            string = "\uD83D\uDFE5";
        }
        return string;
    }

    public boolean isNull(){
        return this.color == Color.NULL;
    }
    private boolean isYellow(){
        return this.color == Color.YELLOW;
    }
   private boolean isRed(){
        return this.color == Color.RED;
    }
}
