// There is a road and on both sides of road, the architect can plan buildings in N slots.
// There is a condition that every two buildings must have a space between them.
// Then in how many different possible ways, can the architect do the planning.

public class BuildingPlanning {

    public static void main(String[] args) {

        int N = 3;
        System.out.println(NCombinations(N));
    }

    private static int NCombinations(int N) {
        int oldSpaces = 1;
        int oldBuildings = 1;

        int newSpaces = oldSpaces;
        int newBuildings = oldBuildings;
        int totCombosAtOneSide=0;

        for (int i = 2; i <= N; i++) {

            newBuildings = oldSpaces;
            newSpaces = oldSpaces+oldBuildings;

            oldSpaces = newSpaces;
            oldBuildings = newBuildings;
        }
        totCombosAtOneSide = oldBuildings+oldSpaces;
        return totCombosAtOneSide*totCombosAtOneSide;
    }

}
