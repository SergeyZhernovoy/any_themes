package collectors_example;

import default_for_book.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoiner {
    private List<Artist> artists;

    public StringJoiner(List<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {

        return this
                .artists
                .stream()
                .map(Artist::getName)
                .collect(Collectors.joining(" ,", " [", "]"));

    }

    public static void main(String[] args) {

        Artist one = new Artist();
        one.setName("Ringo");
        Artist two = new Artist();
        two.setName("John");
        Artist three = new Artist();
        three.setName("Paul");
        Artist four = new Artist();
        four.setName("Lennon");
        Artist five = new Artist();
        five.setName("George");
        List<Artist> artists = Arrays.asList(one,two,three,four,five);
        StringJoiner stringJoiner = new StringJoiner(artists);
        System.out.println(stringJoiner);

    }

}
