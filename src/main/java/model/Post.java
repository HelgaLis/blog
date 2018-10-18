package model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8916521594870346560L;
	private long id;
	private Author author;
	private String title;
	private String text;
<<<<<<< HEAD
	private Set<Tag> tags;
	
	public Post() {
		setTags(new HashSet<>());
	}
	public Post(String title, String text, Author author) {
		this();
		this.title = title;
		this.text = text;
		this.author = author;
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
	@ManyToOne
	@JoinColumn(name = "author_id")
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}	
	public void setTitle(String title) {
		this.title = title;
	}
	@ManyToMany
	@JoinTable(name = "tag", joinColumns=@JoinColumn(name="post_id"),
	inverseJoinColumns=@JoinColumn(name="tag_id"))
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Post - title: "+ title+" text: "+text; 
	}

}
