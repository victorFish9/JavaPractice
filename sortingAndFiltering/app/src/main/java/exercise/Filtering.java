package exercise;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.Post;
import model.User;

public class Filtering {

    /**
     * Filters out deleted posts from the given list of posts. A post is considered
     * deleted if its deletedAt field is not null.
     *
     * @param posts list of posts to filter
     * @return a new list of posts that does not contain deleted posts
     */
    public static List<Post> filterOutDeletedPosts(List<Post> posts) {
        // TODO: Implement filtering logic here.
        return posts.stream()
                .filter(x -> x.deletedAt() == null)
                .collect(Collectors.toList());
    }

    /**
     * Filters out posts that are not written by the given user. A post is
     * considered written by the user if its userId field matches the user's id.
     *
     * @param user  the user to filter posts by
     * @param posts list of posts to filter
     * @return a new list of posts that only contains posts written by the user
     */
    public static List<Post> filterPostsByUser(User user, List<Post> posts) {
        return posts.stream()
                .filter(x -> x.userId() == (user.getId()))
                .collect(Collectors.toList()); // TODO: Implement manual filtering logic here.
    }
}
