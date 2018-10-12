package model;
import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3574776948427834074L;
	private long id;
	private long name;
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
	public long getName() {
		return name;
	}

	public void setName(long name) {
		this.name = name;
	}
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
}
