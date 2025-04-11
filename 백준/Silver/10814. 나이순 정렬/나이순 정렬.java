import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Member> members = new ArrayList<>();

    static class Member {
        int age;
        String name;

        Member (int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }

        members.sort(Comparator.comparingInt(m -> m.age));

        for (Member m: members) {
            System.out.println(m.age + " " + m.name);
        }
    } // main
}
