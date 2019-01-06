public enum Level implements Screenable{
    X_A("x-a",1),
    X_B("x-b",2),
    X_C("x-c",3),
    X_D("x-d",4),
    X_E("x-e",5),
    X_F("x-f",6),
    X_G("x-g",7),
    ZERO("变动坐标点0号",8),
    ;

    String name;
    int index;

    private Level(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static Level byName(String name){
        for(Level l : Level.values()){
            if(l.name.equals(name)){
                return l;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
