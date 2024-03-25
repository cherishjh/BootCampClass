package C17ExceptionfFileParsing.AuthorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class AuthorRepository {
    List<Author> authors;
    AuthorRepository(){
        authors = new ArrayList<>();
    }
    void register(Author author){
        authors.add(author);
    }
    List<Author> getAuthors(){
        return authors;
    }
    Optional<Author> getAuthorByEmail(String email){
        for(Author a : this.authors){
            if(a.getEmail().equals(email)){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}