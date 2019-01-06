import java.util.ArrayList;

public enum Rules {
    Rule1('&', new String[]{"死灵","魔性"}, new String[]{"骷髅兵"}),
    Rule2('&', new String[]{"骷髅兵"}, new String[]{"x-a"})
    ;

    char op;
    ArrayList<Screenable> predecessor;
    ArrayList<Screenable> post;

    private Rules(char op, String[] pred, String[] post){
        this.op = op;
        this.predecessor = new ArrayList<>();
        this.post = new ArrayList<>();
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

    public ArrayList<Screenable> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(ArrayList<Screenable> predecessor) {
        this.predecessor = predecessor;
    }

    public ArrayList<Screenable> getPost() {
        return post;
    }

    public void setPost(ArrayList<Screenable> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        if(!this.predecessor.isEmpty()){
            sb.append(this.predecessor.get(0).getName());
            int len = this.predecessor.size();
            for(int i = 1; i < len; i++){
                sb.append(' ');
                sb.append(this.op);
                sb.append(' ');
                sb.append(this.predecessor.get(i).getName());
            }
        }
        sb.append("} -> {");
        if(!this.post.isEmpty()){
            sb.append(this.post.get(0).getName());
            int len = this.post.size();
            for(int i = 1; i < len; i++){
                sb.append(" , ");
                sb.append(this.post.get(i).getName());
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
