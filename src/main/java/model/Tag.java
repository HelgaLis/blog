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

	private Set<Post> posts;
	
	public Tag() {
		setPosts(new HashSet<>());
	}
	public Tag(String title) {
		this();
		this.title = title;
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
	//@ManyToMany(cascade = { CascadeType.ALL })
	//@JoinTable(name = "tag", joinColumns=@JoinColumn(name="tag_id"),
	//inverseJoinColumns=@JoinColumn(name="post_id"))
	@ManyToMany(mappedBy = "tags")
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public void addPost(Post post) {
		posts.add(post);
	}

}
