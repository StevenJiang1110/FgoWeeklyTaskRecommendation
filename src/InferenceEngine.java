import java.util.HashSet;

public class InferenceEngine {
    public HashSet<Screenable> infer(HashSet<Screenable> pred){
        HashSet<Screenable> current = new HashSet<>();
        HashSet<Rules> hitRule = new HashSet<>();
        current.addAll(pred);

        int oldsize = 0;
        int newSize = current.size();

        while(oldsize != newSize){
            oldsize = current.size();
            for(Rules r : Rules.values()){
                if(isRuleSatisfied(r, current)){
                    current.addAll(r.getPost());
                    hitRule.add(r);
                }
            }
            newSize = current.size();
        }

        HashSet<Screenable> level = new HashSet<>();
        for(Screenable s : current){
            Level screenable = Level.byName(s.getName());
            if(screenable != null){
                level.add(screenable);
            }
        }

        System.out.println("命中的规则有：");

        for(Rules r : hitRule){
            System.out.println(r);
        }
        return level;
    }

    public boolean isRuleSatisfied(Rules rule, HashSet<Screenable> current){
        HashSet<Screenable> pred = rule.getPredecessor();
        if(rule.getOp() == '&'){
            for(Screenable s : pred){
                if(!current.contains(s)){
                    return false;
                }
            }
            return true;
        }else{
            for(Screenable s : pred){
                if(current.contains(s)){
                    return true;
                }
            }
            return false;
        }
    }

}
