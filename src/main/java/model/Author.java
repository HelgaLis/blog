package model;
import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
<<<<<<< HEAD
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
	private Set<Post> posts;
	public Author() {
		posts = new HashSet<Post>();
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
		return "Author - name:"+name+ " id: "+id;

}
