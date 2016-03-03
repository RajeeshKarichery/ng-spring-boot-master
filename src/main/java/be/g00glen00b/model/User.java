package be.g00glen00b.model;

import javax.persistence.*;


@Entity
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String name;
  @Column
  private String loginid;
  @Column
  private String password;
  

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
	
	public String getLoginid() {
		return loginid;
	}
	
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	
  
  

  
}

