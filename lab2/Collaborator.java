abstract class Collaborator extends Employee {
    private String company;
    private String country;
    private int price;
    private static int countObject = 0;

    public Collaborator() {
        super();
        countObject++;
    }

    public Collaborator(String name, int age, String department, String company, String country, int price) {
        super(name, age, department);
        this.company = company;
        this.country= country;
        this.price = price;
        countObject++;
    }

    public String getBrand() {
        return company;
    }

    public void setBrand(String company) {
        this.company = company;
    }

    public String getModel() {
        return country;
    }

    public void setModel(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void doWork() {
        System.out.println("Doing work as an appliance.");
    }

    public static int getCountObject() {
        return countObject;
    }

    public abstract void printInfo();
}
