import java.util.ArrayList;

public enum Enemy implements Screenable{
    SergeantSaber("骷髅兵（剑）",new String[]{"死灵","魔性"}),
    SergeantLancer("骷髅兵（枪）"),
    SergeantArcher("骷髅兵（弓）"),
    ShadowFollowerRider("影从者（骑）"),
    ShadowFollowerLancer("影从者（枪）"),
    ShadowFollowerAssassin("影从者（杀）"),
    ShadowFollowerBerserker("影从者（狂）"),
    DragonSoilerSaber("龙牙兵（剑）"),
    DragonSoilderArcher("龙牙兵（弓）"),
    DragonSoilderAssassin("龙牙兵（杀）"),
    ShadowFollowerSaber("影从者（剑）"),
    ;

    String name;
    ArrayList<Attributes> attributes_list;

    private Enemy(String name, String[] list){
        this.name = name;
        this.attributes_list = new ArrayList<>();
        if(list != null){
            for(String s : list){
                Attributes a = Attributes.byName(s);
                attributes_list.add(a);
            }
        }
    }

    private Enemy(String name){
        this(name, null);
    }

    public static Enemy byName(String name){
        for(Enemy e: Enemy.values()){
            if(e.name.equals(name)){
                return e;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attributes> getAttributes_list() {
        return attributes_list;
    }

    public void setAttributes_list(ArrayList<Attributes> attributes_list) {
        this.attributes_list = attributes_list;
    }
}
