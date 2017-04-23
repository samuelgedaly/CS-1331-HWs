/**
* TenXer abstract class which is the parent for the rest of the classes.
* @version 1.0
* @author Samuel Gedaly
*/
public abstract class TenXer implements Comparable<TenXer> {

    protected String name;
    protected int salary;
    protected int experience;

/**
* TenXer constructor creates a Ceo object
* @param name TenXer's name
* @param salary TenXer's salary
* @param experience TenXer's experience
*/
    public TenXer(String name, int salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

/**
* Overrides the toString method to return a string representation of the
* TenXer's attributes
* @return returns a string representation of the attributes of the TenXer
*/
    @Override
    public String toString() {
        return "TenXer: " + "name: " + name + ". Salary: " + salary
            + ". Years of experience: " + experience + ".";
    }

 /**
* Overrides the equals method
* @param other type Object
* @return returns true or false if its equal to the object
*/
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof TenXer)) {
        
            return false;
        }

        TenXer otherTenXer = (TenXer) other;

        return otherTenXer.getExperience() == experience
                && otherTenXer.getSalary() == salary
                && otherTenXer.getName().equals(name);
    }

/**
* Overrides the compareTo method
* @param other of type TenXer
* @return returns an int
*/
    @Override
    public int compareTo(TenXer other) {
        if (experience > other.getExperience()) {
            return 1;
        } else if (experience == other.getExperience()) {
            if (salary > other.getSalary()) {
                return 1;
            } else if (salary == other.getSalary()) {
                return name.compareTo(other.getName());
            } else {
                return -1;
            }
        }   else {
            return -1;
        }
    }

/**
* getter method to get the name.
* @return returns a String, the name.
*/
    public String getName() {
        return name;
    }
/**
* getter method to get the salary
* @return returns an int, the salary
*/
    public int getSalary() {
        return salary;
    }

/**
* getter method to get the experience
* @return returns an int, the years of experience
*/
    public int getExperience() {
        return experience;
    }
}