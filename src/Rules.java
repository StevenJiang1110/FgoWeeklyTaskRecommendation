import java.util.ArrayList;
import java.util.HashSet;

public enum Rules {
    Rule1('|', new String[]{"死灵","魔性","剑","人"}, new String[]{"骷髅兵（剑）"}),
    Rule2('&', new String[]{"骷髅兵（剑）"}, new String[]{"x-a"}),
    Rule3('|', new String[]{"死灵","魔性","枪","人"}, new String[]{"骷髅兵（枪）"}),
    Rule4('|', new String[]{"骷髅兵（枪）","骷髅兵（剑）"}, new String[]{"x-b","x-c"}),
    Rule5('|', new String[]{"死灵", "魔性", "弓", "人"}, new String[]{"骷髅兵（弓）"}),
    Rule6('|', new String[]{"骷髅兵（弓）","骷髅兵（剑）"}, new String[]{"x-d"}),
    Rule7('&', new String[]{"骑","人"}, new String[]{"影从者（骑）"}),
    Rule8('|', new String[]{"骷髅兵（剑）","骷髅兵（弓）","影从者（骑）"},new String[]{"x-e"}),
    Rule9('&', new String[]{"枪","人"}, new String[]{"影从者（枪）"}),
    Rule10('&', new String[]{"杀","人"}, new String[]{"影从者（杀）"}),
    Rule11('|', new String[]{"骷髅兵（弓）","骷髅兵（剑）","影从者（枪）","影从者（骑）"}, new String[]{"x-f"}),
    Rule12('&', new String[]{"狂","人"}, new String[]{"影从者（狂）"}),
    Rule13('&', new String[]{"影从者（狂）"}, new String[]{"x-g"}),
    Rule14('&', new String[]{"剑","地"}, new String[]{"龙牙兵（剑）"}),
    Rule15('&', new String[]{"弓","地"}, new String[]{"龙牙兵（弓）"}),
    Rule16('&', new String[]{"杀","地"}, new String[]{"龙牙兵（杀）"}),
    Rule17('&', new String[]{"剑","人"}, new String[]{"影从者（剑）"}),
    Rule18('|', new String[]{"龙牙兵（杀）","龙牙兵（弓）","龙牙兵（杀）","影从者（剑）"}, new String[]{"变动坐标点0号"}),
    ;

    char op;
    HashSet<Screenable> predecessor;
    HashSet<Screenable> post;

    private Rules(char op, String[] pred, String[] post){
        this.op = op;
        this.predecessor = new HashSet<>();
        this.post = new HashSet<>();
        for(String s: pred){
            Screenable screen = Screenable.byName(s);
            if(s == null) continue;
            this.predecessor.add(screen);
        }

        for(String s: post){
            Screenable screen = Screenable.byName(s);
            if(screen == null) continue;
            this.post.add(screen);
        }
    }



    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public HashSet<Screenable> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(HashSet<Screenable> predecessor) {
        this.predecessor = predecessor;
    }

    public HashSet<Screenable> getPost() {
        return post;
    }

    public void setPost(HashSet<Screenable> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        if(!this.predecessor.isEmpty()){
            boolean isFirst = true;
            for(Screenable s : this.predecessor){
                if(isFirst){
                    isFirst = false;
                }else{
                    sb.append(' ');
                    sb.append(this.op);
                    sb.append(' ');
                }
                sb.append(' ');
                sb.append(s.getName());
            }
        }
        sb.append("} -> {");
        if(!this.post.isEmpty()){
            boolean isFirst = true;
            for(Screenable s : this.post){
                if(isFirst){
                    isFirst = false;
                }else{
                    sb.append(' ');
                    sb.append(this.op);
                    sb.append(' ');
                }
                sb.append(' ');
                sb.append(s.getName());
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
