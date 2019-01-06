import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String... args){
        ArrayList<String> userSelective = new ArrayList<>();
        userSelective.add("");
        for(Job b : Job.values()){
            userSelective.add(b.getName());
        }
        for(Group g : Group.values()){
            userSelective.add(g.getName());
        }
        for(Attributes a : Attributes.values()){
            userSelective.add(a.getName());
        }

        System.out.println("请从一下属性中选择任意多项，以英文逗号分开（例如：1,3,5）：");

        int i = 1;
        for(String s : userSelective){
            if(s.length() > 0){
                System.out.print(i);
                System.out.print(" : ");
                System.out.print(s);
                System.out.print("\t\t\t\t");
                if( i % 4 == 0) System.out.print('\n');
                i ++;
            }
        }
        System.out.println();
        System.out.println("请输入：");

        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        String[] inputIndex = inputLine.split(",");
        ArrayList<String> input = new ArrayList<>();
        for(String s: inputIndex){
            int len = userSelective.size();
            int index = Integer.parseInt(s);
            if(index >0 && index < len){
                input.add(userSelective.get(index));
            }
        }


        HashSet<Screenable> screen = new HashSet<>();

        for(String s : input){
            screen.add(Screenable.byName(s));
        }

        InferenceEngine engine = new InferenceEngine();
        HashSet<Screenable> result = engine.infer(screen);

        System.out.println("\n你可以攻打以下关卡：");
        for(Screenable s : result){
            System.out.println(s.getName());
        }
    }
}
