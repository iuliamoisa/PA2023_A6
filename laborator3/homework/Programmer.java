public class Programmer extends Person{
    private String specialization;
    Programmer(String name, String birthdate){

        this.name = name;
        this.birthdate = birthdate;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "\nProgrammer{ " + super.toString()
                + specialization  + " }";
    }
}
