//从者所具有的属性
public enum Attributes implements Screenable{
    Necromancer("死灵",1),
    Magic("魔性",2),
    King("王",3),
    Man("男性",4),
    Human("人类",5),
    HumanType("人型",6),
    Romam("罗马",7),
    Demon("恶魔",8),
    Woman("女性",9),
    Dragon("龙",10),
    SuperHuge("超巨大",11),
    Greece("希腊",12),
    MythologyMale("神话系男性",13),
    Beast("猛兽",14),
    Divinity("神性",15),
    EASpecialAttacked("被EA特攻",16),
    SkyGroundServant("天地从者",17),
    Evil("恶",18),
    HumanThreat("人类威胁",19),
    ;

    String name;
    int index;

    private Attributes(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static Attributes byName(String name){
        for(Attributes a: Attributes.values()){
            if(a.name.equals(name)){
                return a;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
