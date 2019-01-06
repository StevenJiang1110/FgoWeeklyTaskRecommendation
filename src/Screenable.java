public interface Screenable {
    public String getName();

    public static Screenable byName(String s){
        Screenable screen = Group.byName(s);
        if(screen == null) screen = Attributes.byName(s);
        if(screen == null) screen = Enemy.byName(s);
        if(screen == null) screen = Level.byName(s);
        if(screen == null) screen = Job.byName(s);
        return screen;
    }
}
