package Domain.ServicioInformacion.Endpoints.Common;

public class Team {
  private Integer id;
  private String name;
  private String code;
  private String country;
  private Integer founded;
  private Boolean national;
  private String logo;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getFounded() {
    return founded;
  }

  public void setFounded(Integer founded) {
    this.founded = founded;
  }

  public Boolean getNational() {
    return national;
  }

  public void setNational(Boolean national) {
    this.national = national;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  @Override
  public String toString() {
    return "Team{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", country='" + country + '\'' +
        ", founded=" + founded +
        ", national=" + national +
        ", logo='" + logo + '\'' +
        '}';
  }

}
