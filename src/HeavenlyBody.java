import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> sattelites;


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.sattelites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        this.sattelites.add(moon);
        return true;
    }

    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSattelites() {
        return new HashSet<>(this.sattelites);
    }

    // Both override methods are needed to get the same object from the HashSet
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) { // which confirms that it is the right type of class
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID

    }


    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }
    @Override
    public String toString() {
        return this.key.name + " : " + this.key.bodyType + " : " + this.orbitalPeriod;
    }

    public static final class Key {
        private final String name;
        private final BodyTypes bodyType;

        public Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return this.name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + " : " + this.bodyType;
        }
    }
}

//the Heavenly body class is declared final, so cannot be subclassed.
// the Java String class is also final, which is why it can safely use the instanceof method without having to worry
// about comparisons with a subclass. (lecture 97)