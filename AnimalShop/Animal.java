public class Animal {
    private String AnimalEGN;
    private String name;
    private int age;

    public Animal(String AnimalEGN,String name,int age){
        this.setAnimalEGN(AnimalEGN);
        this.setName(name);
        this.setAge(age);
    }
    public void setAnimalEGN(String AnimalEGN){
        this.AnimalEGN=AnimalEGN;
    }
    public String getAnimalEGN(){
        return this.AnimalEGN;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return this.age;
    }
}
