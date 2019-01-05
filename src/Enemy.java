public enum Enemy implements Screenable{
    Sergeant("骷髅兵",new Attributes[]{Attributes.byName("死灵"), Attributes.byName("魔性")});

    String name;
    Attributes[] attributes_list;

    private Enemy(String name, Attributes[] list){
        this.name = name;
        this.attributes_list = list;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attributes[] getAttributes_list() {
        return attributes_list;
    }

    public void setAttributes_list(Attributes[] attributes_list) {
        this.attributes_list = attributes_list;
    }
}
