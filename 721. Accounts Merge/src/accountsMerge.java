import java.util.*;

class A {

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailToName = new HashMap();
            Map<String, ArrayList<String>> graph = new HashMap();
            for (List<String> account: accounts) {
                String name = "";
                for (String email: account) {
                    if (name == "") {
                        name = email;
                        continue;
                    }
                    graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                    graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                    emailToName.put(email, name);
                }
            }

            Set<String> seen = new HashSet();
            List<List<String>> ans = new ArrayList();
            for (String email: graph.keySet()) {
                if (!seen.contains(email)) {
                    seen.add(email);
                    Stack<String> stack = new Stack();
                    stack.push(email);
                    List<String> component = new ArrayList();
                    while (!stack.empty()) {
                        String node = stack.pop();
                        component.add(node);
                        for (String nei: graph.get(node)) {
                            if (!seen.contains(nei)) {
                                seen.add(nei);
                                stack.push(nei);
                            }
                        }
                    }
                    Collections.sort(component);
                    component.add(0, emailToName.get(email));
                    ans.add(component);
                }
            }
            return ans;
        }

        public List<List<String>> accountsMerge1(List<List<String>> acts) {
            Map<String, String> owner = new HashMap<>();
            Map<String, String> parents = new HashMap<>();
            Map<String, HashSet<String>> unions = new HashMap<>();
            for (List<String> a : acts) { // initiates owner and parents;
                for (int i = 1; i < a.size(); i++) {
                    parents.put(a.get(i), a.get(i));
                    owner.put(a.get(i), a.get(0));
                }
            }
            for (List<String> a : acts) { // implements the parents_map;
                String p = find(a.get(1), parents);//p=cur_parent
                for (int i = 2; i < a.size(); i++)
                    parents.put(find(a.get(i),parents), p);// find its prev parents, and put(prev_parent, curr_parent)
            }
            for(List<String> a : acts) { // build the HashSet according to parents_map;
                String p = find(a.get(1), parents);
                if (!unions.containsKey(p))
                    unions.put(p, new HashSet<>());
                for (int i = 1; i < a.size(); i++)
                    unions.get(p).add(a.get(i));
            }


            List<List<String>> res = new ArrayList<>();
            for (String p : unions.keySet()) { // build res according to HashSet.
                List<String> emails = new ArrayList(unions.get(p));
                emails.add(0, owner.get(p));
                res.add(emails);
            }
            return res;
        }
        private String find(String s, Map<String, String> p) {
            return p.get(s) == s ? s : find(p.get(s), p);
        }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }

    public List<String> toListString(String[] s){
        List<String> res = new LinkedList<>();
        for(String si: s) res.add(si);
        return res;
    }

    public void start(){
        /*String[] s1= {"John","johnsmith@mail.com","john00@mail.com"};
        String[] s2= {"John","johnnybravo@mail.com"};
        String[] s3= {"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        String[] s4= {"Mary", "mary@mail.com"};*/

        String[] s1= {"D","0","4","3"};
        String[] s2= {"D","5","5","0"};
        String[] s3= {"D","1","0"};

        List<List<String>> accounts = new LinkedList<>();
        accounts.add(toListString(s1));
        accounts.add(toListString(s2));
        accounts.add(toListString(s3));

        System.out.println(accountsMerge(accounts).toString());
    }
}
