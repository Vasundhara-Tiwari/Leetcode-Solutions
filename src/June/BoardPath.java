package June;

public class BoardPath {
    public static void main(String[] args) {
        printAllPath(0, 0, 2, 2, "");
    }
    public static void printAllPath(int cr, int cc, int er, int ec, String ans){
        if(cr >= er && cc >= ec){
            System.out.println(ans);
            return;
        }
        if(cc > ec || cr > er){
            return;
        }
        printAllPath(cr, cc+1, er, ec, ans+"H");
        printAllPath(cr+1, cc, er, ec, ans+"V");
    }
}
