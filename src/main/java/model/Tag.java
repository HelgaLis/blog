package model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4553122933740870265L;
	private long id;
	private String title;
	//private Set<Post> posts;
	
	public Tag() {
		//setPosts(new HashSet<>());
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
	@Column(name = "title", unique = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}*/
}
