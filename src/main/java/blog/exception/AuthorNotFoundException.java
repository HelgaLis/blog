package blog.exception;

public class AuthorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5010766568209589247L;
	private long authorId;
	public AuthorNotFoundException(long authorId){
		this.authorId = authorId;
	}
	public long getAuthorId(){
		return authorId;
	}

}
