public enum Job implements Screenable{
    Saber("剑",1),
    Archer("弓",2),
    Lancer("枪",3),
    Rider("骑",4),
    Caster("术",5),
    Assassin("杀",6),
    Berserker("狂",7),
    Ruler("裁定者",8),
    Avenger("复仇者",9),
    Alterego("小丑阶",10),
    Shielder("盾阶",11),
    Foreigner("外乡人",12),
    Mooncancer("月癌",13);

    String name;
    int index;

    private Job(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static Job byName(String s){
        for(Job j: Job.values()){
            if(j.name.equals(s)){
                return j;
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
