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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (!(obj instanceof Tag)) {
			return false;
		}
		Tag other = (Tag) obj;
		if (id != other.id) {
			return false;
		}
		if (posts == null) {
			if (other.posts != null) {
				return false;
			}
		} else if (!posts.equals(other.posts)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}*/

}
