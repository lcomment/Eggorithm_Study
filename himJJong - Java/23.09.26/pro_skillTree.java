import java.util.*;

class pro_skillTree {
    static HashMap<String, Integer> map = new HashMap<>();
    static int answer = 0;
    static int skillIndex = 0;
    static String[] skillArr;
    static String[] skill_trees_element;
    public int solution(String skill, String[] skill_trees) {
        skillArr = skill.split("");
        for(int i=0; i<skillArr.length; i++){
            map.put(skillArr[i],0);
        }

        for(int i=0; i<skill_trees.length; i++){
            boolean flag = true;
            skillIndex = 0;
            skill_trees_element = skill_trees[i].split("");

            for(int j=0; j<skill_trees_element.length; j++){
                if(map.containsKey(skill_trees_element[j])){
                    if(skillArr[skillIndex].equals(skill_trees_element[j])){
                        skillIndex++;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)    answer++;
        }
        return answer;
    }
}