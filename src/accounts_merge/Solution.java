package accounts_merge;


import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToAccIdMap = new HashMap();
        int relationVec[] = new int[accounts.size()];


        for (int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            relationVec[i] = i;
            for (int k = 1; k < acc.size(); k++) {
                String email = acc.get(k);
                if (emailToAccIdMap.containsKey(email)) {
                    int accId = emailToAccIdMap.get(email);
                    while (i != relationVec[accId]) {
                        int t = relationVec[accId];
                        relationVec[accId] = i;
                        accId = t;
                    }
                } else {
                    emailToAccIdMap.put(email, i);
                }
            }
        }

        List<List<String>> res = new LinkedList();
        for (int i = 0; i < relationVec.length; i++) {
            if (relationVec[i] == i) {

                res.add(accounts.get(i));
            } else {

                int t = relationVec[i];
                while (t != relationVec[t]) {
                    t = relationVec[t];
                }
                combine(accounts.get(i), accounts.get(t));
            }
        }

        for (List<String> l : res) {
            Set<String> set = new HashSet();
            for (int i = 1; i < l.size(); i++) {
                set.add(l.get(i));
            }
            String s = l.get(0);
            l.clear();
            l.addAll(set);
            Collections.sort(l);
            l.add(0, s);
        }
        return res;
    }


    private void combine(List<String> list1, List<String> list2) {
        for (int i = 1; i < list1.size(); i++) {
            list2.add(list1.get(i));
        }
    }
}
