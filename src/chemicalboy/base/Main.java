package chemicalboy.base;

public class Main {

    public static void main(String[] args) {

        boolean wePlay = true;

        Listener listener = new Listener();

        String command = listener.hello();

        if(command.equals("QUIT")){
            wePlay = false;
        }

        while(wePlay){
            switch (command){
                case "MAIN":
                    command = listener.main();
                    break;
                case "STATISTIC":
                    command = listener.statistic();
                    break;
                case "ROLL":
                    command = listener.roll();
                    break;
                case "MIX":
                    command = listener.mix();
                    break;
                case "QUIT":
                    wePlay = false;

            }

        }

    }
}
