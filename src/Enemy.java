import java.util.ArrayList;

public enum Enemy implements Screenable{
    Sergeant("骷髅兵",new String[]{"死灵","魔性"});

    String name;
    ArrayList<Attributes> attributes_list;

    private Enemy(String name, String[] list){
        this.name = name;
        this.attributes_list = new ArrayList<>();
        for(String s : list){
            Attributes a = Attributes.byName(s);
            attributes_list.add(a);
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
