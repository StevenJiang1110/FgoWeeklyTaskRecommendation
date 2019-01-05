//从者所属阵营
public enum Group {
    SKY("天",1),
    GROUND("地",2),
    PERSON("人",3);

    private String name;
    private int index;

    private Group(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static Group getGruopByName(String name){
        for(Group g: Group.values()){
            if (g.name.equals(name)){
                return g;
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
