package default_for_book;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Sergey Zhernovoy
 * create on 10.08.2017.
 */

public class Album {
    private Artist artist;
    private List<Track> tracklist;

    public Album(Artist artist, List<Track> tracklist) {
        this.artist = artist;
        this.tracklist = tracklist;
    }

    public Album() {
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Stream<Track> getTracklist() {
        return tracklist.stream();
    }

    public void setTracklist(List<Track> tracklist) {
        this.tracklist = tracklist;
    }
}

    