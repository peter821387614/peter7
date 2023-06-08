import java.util.*;

public class simple_dice_game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int control = 1;
        int times = 1;
        System.out.println("玩家會丟3顆骰子，每一個骰子都是六面。\n1. "
        		+ "如果骰子出現三個一樣的數字，顯示「豹子」\n2. "
        		+ "如果骰子出現連續的數，例如：2,3,4，顯示「順子」\n3. "
        		+ "如果有兩個骰子出現相同的數，顯示「一對」\n4. "
        		+ "以上皆非的話，顯示三個骰子加起來的總合\n");
        System.out.println("請輸入【1】開始遊戲 或【2】結束遊戲");
        control = scan.nextInt();
        while (control == 1) {
            if (control == 2) {
                System.out.println("遊戲結束！");
                break;
            }
            System.out.println("這是您第" + times + "次遊玩。\n");
            Players player1 = new Players();
            player1.Storage();
            player1.DisplayNum();
            player1.Judge();
            times++;
            System.out.println("");
            System.out.println("請輸入【1】再玩一次 或【2】結束遊戲");
            control = scan.nextInt();
        }
    }
}
// 玩家
class Players {
    ArrayList<Dice> diceList = new ArrayList<Dice>();
    Dice d1 = new Dice();
    Dice d2 = new Dice();
    Dice d3 = new Dice();

    void Storage() {
        diceList.add(d1);
        diceList.add(d2);
        diceList.add(d3);
    }

    void DisplayNum() {
        for (int i = 0; i < diceList.size(); i++) {
            System.out.print((diceList.get(i).num) + ", ");
        }
        System.out.println("");
    }
    // 判斷
    void Judge() {
        int repeat = 0; // 重複次數
        int straight = 0; // 遞增現象偵測到的次數
        for (int i = 0; i < diceList.size(); i++) {
            for (int j = i + 1; j < diceList.size(); j++) {
                if ((diceList.get(i).num) == (diceList.get(j).num )) {
                    repeat++;
                }
                if (((diceList.get(i).num) + 1) == (diceList.get(j).num )) {
                    straight++;
                }
            }
        }
        if (repeat == 1) {
            System.out.println("一對");
        } else if (repeat == diceList.size()) {
            System.out.println("豹子");
        } else if (straight == (diceList.size()) - 1) {
            System.out.println("順子");
        } else {
            int total = 0;
            for (int i = 0; i < diceList.size(); i++) {
                total += diceList.get(i).num;
            }
            System.out.println(total);
        }
    }

}
// 骰子
class Dice {
    Random ran = new Random();
    int num = (ran.nextInt(6) + 1); // 1~6 隨機生成
}
