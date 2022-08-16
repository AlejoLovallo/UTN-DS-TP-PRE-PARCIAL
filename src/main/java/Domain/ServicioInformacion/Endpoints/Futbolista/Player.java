package Domain.ServicioInformacion.Endpoints.Futbolista;

public class Player {
  private Integer id;
  private String name;
  private String firstname;
  private String lastname;
  private Integer age;
  private String nationality;
  private Object height;
  private Object weight;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Object getHeight() {
    return height;
  }

  public void setHeight(Object height) {
    this.height = height;
  }

  public Object getWeight() {
    return weight;
  }

  public void setWeight(Object weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Futbolista{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", age=" + age +
        ", nationality='" + nationality + '\'' +
        ", height=" + height +
        ", weight=" + weight +
        '}';
  }
}