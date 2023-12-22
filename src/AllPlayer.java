import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPlayer {
    static ArrayList<Integer> user = new ArrayList<>();
    static ArrayList<Integer> cpu = new ArrayList<>();



    public static void printGameBoard(char[][] gameBoard){
        for (char[] row:gameBoard) {
            for (char c:row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String player){
        char symbols = ' ';
        if(player.equals("user")){
            symbols ='X';
            user.add(position);
        }else if(player.equals("cpu")){
            symbols ='O';
            cpu.add(position);
        }
        switch (position){
            case 1:
                gameBoard[0][0] = symbols;
                break;
            case 2:
                gameBoard[0][2] = symbols;
                break;
            case 3:
                gameBoard[0][4] = symbols;
                break;
            case 4:
                gameBoard[2][0] = symbols;
                break;
            case 5:
                gameBoard[2][2] = symbols;
                break;
            case 6:
                gameBoard[2][4] = symbols;
                break;
            case 7:
                gameBoard[4][0] = symbols;
                break;
            case 8:
                gameBoard[4][4] = symbols;
                break;
            case 9:
                gameBoard[4][4] = symbols;
                break;
        }
    }

    public static String checkWinner(int type){
        List topRows = Arrays.asList(1,2,3);
        List midRows = Arrays.asList(4,5,6);
        List botRows = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List daig1 = Arrays.asList(2,5,8);
        List daig2 = Arrays.asList(3,6,9);

        List<List> win = new ArrayList<List>();
        win.add(topRows);
        win.add(midRows);
        win.add(botRows);
        win.add(leftCol);
        win.add(rightCol);
        win.add(midCol);
        win.add(daig1);
        win.add(daig2);

        for (List l: win) {
            if(user.containsAll(l)){
                return "Congratulations! Player 1 You Won";
            }else if (cpu.containsAll(l)){
                if(type ==0){
                    return "Sorry Try Next Time :( CPU Won!";
                }else if(type ==1){
                    return "Congratulations! Player 2 You Won";
                }

            }else if (cpu.size()+user.size()==9){
                return "CAT";
            }
        }

        return "";

    }

}
