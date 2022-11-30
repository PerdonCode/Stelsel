import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> sattelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.sattelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void addMoon(HeavenlyBody moon) {
        this.sattelites.add(moon);
    }

    public Set<HeavenlyBody> getSattelites() {
        return new HashSet<>(this.sattelites);
    }
    // beide override methods heb je nodig om de zelfde objects uit de Hashset te halen
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
       System.out.println("obj.getClass() = " + obj.getClass());
       System.out.println("this.getClass() + " + this.getClass());

       if ((obj == null) ||(obj.getClass() != this.getClass())){
           return false;
       }
       String objName = ((HeavenlyBody) obj).getName();
       return this.name.equals((objName));
    }
    @Override
    public int hashCode() {
        System.out.println("hashcode called" );
        return this.name.hashCode() + 57;
    }
}
