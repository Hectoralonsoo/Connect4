
package Model;
public enum Color {
    YELLOW,
    RED,
    NULL;

     public static Color get(int index){
        return Color.values()[index];
    }
}
