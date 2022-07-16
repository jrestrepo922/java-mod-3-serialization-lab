import java.io.*;

public class Person  implements Serializable {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    public Person(){

    }
    public Person(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    public Person(String personCSV) {
        String[] personValues = personCSV.split(",");
        this.firstName = personValues[0];
        this.lastName = personValues[1];
        this.birthYear = Integer.valueOf(personValues[2]);
        this.birthMonth = Integer.valueOf(personValues[3]);
        this.birthDay = Integer.valueOf(personValues[4]);
        System.out.println("Initialized person object from CSV string");
        System.out.println(this);
    }




    @Override
    public String toString() {
        StringBuffer personString = new StringBuffer();
        personString.append("firstName = " + firstName);
        personString.append("\n");
        personString.append("lastName = " + lastName);
        personString.append("\n");
        personString.append("Birth date = ");
        personString.append(birthMonth + "/");
        personString.append(birthDay+ "/");
        personString.append(birthYear);
        personString.append("\n");

        return personString.toString();
    }

    public String formatAsCSV() {
        StringBuffer personString = new StringBuffer();
        personString.append(firstName);
        personString.append(",");
        personString.append(lastName);
        personString.append(",");
        personString.append(birthYear);
        personString.append(",");
        personString.append(birthMonth);
        personString.append(",");
        personString.append(birthDay);
        // just returns a string representation of the StringBuffer dataType;
        return personString.toString();
    }

    public static void serializePerson(Person person, String fileName) throws IOException {
        ObjectOutputStream personObjectStream = null;
        try {
            FileOutputStream personFile = new FileOutputStream(fileName + ".dat");
            personObjectStream = new ObjectOutputStream(personFile);
            personObjectStream.writeObject(person);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (personObjectStream != null) {
                personObjectStream.flush();
                personObjectStream.close();
            }
        }
    }

    public static Person deserializePerson(String fileName) throws IOException {
        ObjectInputStream personInputStream = null;
        Person newPerson = null;
        try {
            FileInputStream personFile = new FileInputStream(fileName + ".dat");
            personInputStream = new ObjectInputStream(personFile);
            newPerson = (Person) personInputStream.readObject();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (personInputStream != null) {
                personInputStream.close();
            }
        }

        return newPerson;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }
}

