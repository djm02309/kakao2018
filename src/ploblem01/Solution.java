package ploblem01;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        String[][] all = new String[3][record.length];  //[Enter/Change/Leave][유저아이디][닉네임]
        Map<String, String> map = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            all[0][i] = st.nextToken();
            all[1][i] = st.nextToken();
            if (st.hasMoreTokens()) {
                all[2][i] = st.nextToken();
            } else {
                all[2][i] = "";
            }
            if (!map.containsKey(all[1][i])) {
                map.put(all[1][i], all[2][i]);
            }
            if (all[0][i].equals("Enter") && map.containsKey(all[1][i])) {
                map.replace(all[1][i], all[2][i]);
            }
            if (all[0][i].equals("Change")) {
                map.replace(all[1][i], all[2][i]);
            }
        }
        int a = all.length;
        for (int i = 0; i < record.length; i++) {
            String name = map.get(all[1][i]);
            if (all[0][i].equals("Enter")) {
                list.add(name + "님이 들어왔습니다.");
            }
            if (all[0][i].equals("Leave")) {
                list.add(name + "님이 나갔습니다.");
            }
        }
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

//    public static void main(String[] args) {
//        String[] answer = {};
//        Solution s = new Solution();
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
//        answer = s.solution(record);
//        for (int i = 0; i < answer.length; i++) {
//            System.out.println(answer[i]);
//        }
//    }
}
