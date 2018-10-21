package model;
import javax.persistence.*;

import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@NamedQuery(name = "Author.findAllWithPosts",
query = "select distinct a from Author a left join fetch a.posts p")
@NamedQuery(name = "Author.findByName",
query = "select distinct a from Author a left join fetch a.posts where a.name = :name")

public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3574776948427834074L;
	private long id;
	private String name;
	private int age;
	private Gender gender;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="age")
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

}
