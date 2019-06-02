package controleur;

public class Users
{
	private int iduser, age, phone, ban, termsUse, idquestion;
	private String lastname, firstname, email, password, right, reply;
	
	public Users()
	{
		this.iduser=this.age=this.phone=this.ban=this.termsUse=this.idquestion = 0;
		this.lastname=this.firstname=this.email=this.password=this.right=this.reply="";
	}
	
	public Users(int iduser, String lastname, String firstname, int age, int phone, String email, String password, String right, int ban, String reply, int termsUse, int idquestion) 
	{
		super();
		this.iduser = iduser;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.right = right;
		this.ban = ban;
		this.reply = reply;
		this.termsUse = termsUse;
		this.idquestion = idquestion;
	}
	
	public Users(int iduser, String lastname, String firstname, int age, int phone, String email, String password, String right)
	{
		this.iduser = iduser;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.right = right;
	}

	public int getIduser() 
	{
	  return iduser;
	}
	public void setIduser(int iduser)
	{
	  this.iduser = iduser;
	}
	public String getLastname()
	{
	  return lastname;
	}
	public void setLastname(String lastname)
	{
	  this.lastname = lastname;
	}
	public String getFirstname()
	{
	  return firstname;
	}
	public void setFirstname(String firstname) 
	{
	  this.firstname = firstname;
	}
	public int getAge() 
	{
	  return age;
	}
	public void setAge(int age) 
	{
	  this.age = age;
	}
	public int getPhone() 
	{
	  return phone;
	}
	public void setPhone(int phone) 
	{
	  this.phone = phone;
	}
	public String getEmail() 
	{
	  return email;
	}
	public void setEmail(String email) 
	{
	  this.email = email;
	}
	public String getPassword() 
	{
	  return password;
	}
	public void setPassword(String password) 
	{
	  this.password = password;
	}
	public String getRight() 
	{
	  return right;
	}
	public void setRight(String right) 
	{
	  this.right = right;
	}
	public int getBan() 
	{
	  return ban;
	}
	public void setBan(int ban) 
	{
	  this.ban = ban;
	}
	public void setReply(String reply) 
	{
	  this.reply = reply;
	}
	public String getReply() 
	{
	  return reply;
	}
	public int getTermsUse() 
	{
	  return termsUse;
	}
	public void setTermsUse(int termsUse) 
	{
	  this.termsUse = termsUse;
	}
	public int getIdquestion() 
	{
	  return idquestion;
	}
	public void setIdquestion(int idquestion) 
	{
	  this.idquestion = idquestion;
	}
}
