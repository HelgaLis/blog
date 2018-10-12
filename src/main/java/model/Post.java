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
	//private Set<Tag> tags;
	
	public Post() {
		//setTags(new HashSet<>());
	}
	
	public Author getAuthor() {
		return author;
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
	@Column(name = "author", unique = true)
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

	/*public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}*/
}
