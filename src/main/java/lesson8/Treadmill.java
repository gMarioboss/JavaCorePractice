package lesson8;

public class Treadmill implements Barriers{
    int distance = (int) (200 + Math.random() * 301);

    @Override
    public boolean overCome(Participants participant) {
       if (participant.run(distance)) {
           System.out.printf("%s (%s) пробежал длину в %s метров!%n", participant.getName(),
                   participant.getRunDistance(), distance);
           return true;
       }
        System.out.printf("%s (%s) не пробежал длину в %s метров!%n",
                participant.getName(), participant.getRunDistance(), distance);
       return false;
    }

    public int getDistance() {
        return distance;
    }

}
