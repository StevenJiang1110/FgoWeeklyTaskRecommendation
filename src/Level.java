public enum Level implements Screenable{
    X_A("x-a",1);

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
