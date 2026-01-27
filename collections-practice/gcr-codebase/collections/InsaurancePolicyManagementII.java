import java.util.*;
import java.time.*;

class InsurancePolicyTwo {
    int no;
    String holder;
    LocalDate exp;
    String type;
    double prem;

    InsurancePolicyTwo(int no, String holder, LocalDate exp, String type, double prem) {
        this.no = no;
        this.holder = holder;
        this.exp = exp;
        this.type = type;
        this.prem = prem;
    }

    public String toString() {
        return no + " " + holder + " " + exp + " " + type + " " + prem;
    }
}

class PolicyStore {
    Map<Integer, InsurancePolicyTwo> map = new HashMap<>();
    Map<LocalDate, List<InsurancePolicyTwo>> expMap = new TreeMap<>();

    void add(InsurancePolicyTwo p) {
        map.put(p.no, p);

        if (!expMap.containsKey(p.exp)) {
            expMap.put(p.exp, new ArrayList<>());
        }
        expMap.get(p.exp).add(p);
    }

    InsurancePolicyTwo get(int no) {
        return map.get(no);
    }

    Collection<InsurancePolicyTwo> all() {
        return map.values();
    }

    Map<LocalDate, List<InsurancePolicyTwo>> byExpiry() {
        return expMap;
    }

    void remove(int no) {
        InsurancePolicyTwo p = map.remove(no);
        if (p == null) return;

        List<InsurancePolicyTwo> list = expMap.get(p.exp);
        list.remove(p);
        if (list.isEmpty()) {
            expMap.remove(p.exp);
        }
    }
}

class PolicyService {

    static void expiringSoon(PolicyStore ps) {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);

        for (LocalDate d : ps.byExpiry().keySet()) {
            if (!d.isBefore(now) && !d.isAfter(limit)) {
                for (InsurancePolicyTwo p : ps.byExpiry().get(d)) {
                    System.out.println(p);
                }
            }
        }
    }

    static void byHolder(PolicyStore ps, String name) {
        for (InsurancePolicyTwo p : ps.all()) {
            if (p.holder.equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    static void removeExpired(PolicyStore ps) {
        LocalDate now = LocalDate.now();
        List<Integer> removeList = new ArrayList<>();

        for (InsurancePolicyTwo p : ps.all()) {
            if (p.exp.isBefore(now)) {
                removeList.add(p.no);
            }
        }

        for (int no : removeList) {
            ps.remove(no);
        }
    }
}

public class InsaurancePolicyManagementII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PolicyStore ps = new PolicyStore();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int no = sc.nextInt();
            String h = sc.next();
            LocalDate d = LocalDate.parse(sc.next());
            String t = sc.next();
            double p = sc.nextDouble();

            ps.add(new InsurancePolicyTwo(no, h, d, t, p));
        }

        int q = sc.nextInt();
        System.out.println(ps.get(q));

        System.out.println("Expiring soon:");
        PolicyService.expiringSoon(ps);

        String name = sc.next();
        System.out.println("By holder:");
        PolicyService.byHolder(ps, name);

        PolicyService.removeExpired(ps);
        System.out.println("After removing expired:");
        for (InsurancePolicyTwo p : ps.all()) {
            System.out.println(p);
        }
        
        sc.close();    }
}
