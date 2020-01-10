package ai.brace;

public class Employee
{
    public String firstName;
    public String middleInitial;
    public String lastName;
    public String socialSecurityNumber;

    public Employee(String _lastName, String _firstName, String _middleInitial, String _socialSecurityNumber)
    {
        firstName = _firstName;
        middleInitial = _middleInitial;
        lastName = _lastName;
        socialSecurityNumber = _socialSecurityNumber;
    }

    // additions
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((socialSecurityNumber == null) ? 0 : socialSecurityNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;

        if (middleInitial == null) {
            if (other.middleInitial != null)
                return false;
        } else if (!middleInitial.equals(other.middleInitial))
            return false;

        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;

        if (socialSecurityNumber == null) {
            if (other.socialSecurityNumber != null)
                return false;
        } else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
            return false;

        return true;
    }
}
