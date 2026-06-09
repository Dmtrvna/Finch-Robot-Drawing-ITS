import BirdBrainJava.Finch;

public class FinchITC {

    public static void symbolI(Finch myFinch, int speed) {
        double[] edges = {40, 7, 17.72, 19, 7};
        String[] direction = {"R", "R", "L", "R", "R"};
        double[] degree = {90, 90, 162, 70, 90};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                myFinch.setMove("F", edges[j], speed);
                myFinch.setTurn(direction[j], degree[j] + 2, speed);
            }
        }
    }

    public static void symbolT(Finch myFinch, int speed) {
        double[] edges = {32, 5.2, 8, 20, 8, 5.2, 32, 9.6};
        String[] direction = {"L", "R", "R", "R", "R", "L", "R", "R"};

        for (int i = 0; i < 8; i++) {
            myFinch.setMove("F", edges[i], speed);
            myFinch.setTurn(direction[i], 90 + 2, speed);
        }
    }

    public static void symbolC(Finch myFinch, int speed) {
        double[] edges = {
                9.9, 26, 9.9, 7, 9.9, 10,
                7, 8, 7, 22, 7, 8, 7, 10,
                9.9, 7
        };
        String[] direction = {
                "L", "R", "R", "R", "R", "R",
                "R", "R", "L", "L", "L", "L", "R", "R",
                "R", "R",
        };
        double[] degree = {
                44, 44, 44, 44, 44, 44,
                90, 90, 90, 90, 90, 90, 90, 90,
                44, 44
        };

        for (int i = 0; i < 16; i++) {
            myFinch.setTurn(direction[i], degree[i] + 2, speed);
            myFinch.setMove("F", edges[i], speed);
        }
    }

    public static void main(String[] args) {
        Finch myFinch = new Finch();

        int speed = 2;

        symbolI(myFinch, speed);

        myFinch.setTurn("R", 90 + 2, speed);
        myFinch.setMove("F", 27, speed);
        myFinch.setTurn("L", 90 + 2, speed);

        symbolT(myFinch, speed);

        myFinch.setTurn("R", 90 + 2, speed);
        myFinch.setMove("F", 25, speed);
        myFinch.setTurn("L", 90 + 2, speed);

        symbolC(myFinch, speed);

        myFinch.stopAll();
        myFinch.disconnect();
    }

    public static class Fox {
    }
}
