package model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NamedQuery(name = "Author.findAllWithPosts",
query = "select distinct a from Author a left join fetch a.posts p")
@NamedQuery(name = "Author.findByName",
query = "select distinct a from Author a left join fetch a.posts where a.name = :name")
@NamedQuery(name="Author.findAll", query="from Author a")
public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3574776948427834074L;
	private long id;
	private String name;
	private int age;
	private Gender gender;
	private String email;
	private Set<Post> posts;
	private Author() {
		posts = new HashSet<Post>();
	}
	public Author(String name, int age, Gender gender){
		this();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", unique = true)
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="age")
	@Min(13)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Column(name="gender", nullable=false)
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public void addPost(Post post) {
		posts.add(post);
	}
	@Override
	public String toString() {
		return "Author - name:"+name+" age: "+age+"gender: "+gender+" id: "+id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if (age != other.age) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (posts == null) {
			if (other.posts != null) {
				return false;
			}
		} else if (!posts.equals(other.posts)) {
			return false;
		}
		return true;
	}*/
	@Column(name="email")
	@Email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
