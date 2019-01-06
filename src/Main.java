public class Main {
    public static void main(String... args){
        Group g = Group.byName("天");
        System.out.println(g.getIndex());

        Rules rule = Rules.Rule1;
        Rules rules = Rules.Rule2;

        System.out.println(rule);
        System.out.println(rules);

        Enemy enemy = Enemy.Sergeant;
    }
}
