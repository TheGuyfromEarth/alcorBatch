// Given a subject array, a student needs to select 3 subjects from the given subject array.
// Two students select some subjects, determine the common  subjects selected between two students.

// Ex: sub = {"Math","Eng","Science","CS","Arts"}
//             0      1        2       3     4

// std1 = Arts,Eng,Science -> 4,1,2 -> 10110 = 22
// std2 = Arts,Math,Science-> 4,0,2 -> 10101 = 21
//                                     10100

// O/p = Science, Arts

public class CommonSubjects {

    public static void main(String[] args) {
        String[] sub = {"Math", "Eng", "Science", "CS", "Arts"};

        // std1 opts for Arts, Eng and Science
        // std2 opts for Arts, Math and Science
        String[] std1 = {"Arts", "Eng", "Science"};
        String[] std2 = {"Arts", "Math", "Science"};

        int sub1 = 0;
        int sub2 = 0;

        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < std1.length; j++) {
                if (sub[i] == std1[j])
                    sub1 = (sub1 | (1 << i));
                if (sub[i] == std2[j])
                    sub2 = (sub2 | (1 << i));
            }
        }

        // common subjects (intersection)
        int commonSubjects = sub1 & sub2;

        for (int i = sub.length - 1; i >= 0; i--) {
            if (((commonSubjects >> i) & 1) == 1)
                System.out.println(sub[i]);
        }
        System.out.println("*********");
        // Set of subjects taken by Std1 and Std2 (Union)
        int unionSubjects = sub1|sub2;
        for (int i = sub.length - 1; i >= 0; i--) {
            if (((unionSubjects >> i) & 1) == 1)
                System.out.println(sub[i]);
        }
    }
}

