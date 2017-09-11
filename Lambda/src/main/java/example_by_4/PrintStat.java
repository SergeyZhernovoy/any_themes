package example_by_4;

import default_for_book.Album;
import default_for_book.Track;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 10.08.2017.
 */

public class PrintStat {
    public static void printTrackLengthStatistics(Album album){
        IntSummaryStatistics trackLengthStats
                = album
                    .getTracklist()
                    .mapToInt(Track::getLength)
                    .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                            trackLengthStats.getMax(),
                            trackLengthStats.getMin(),
                            trackLengthStats.getAverage(),
                            trackLengthStats.getSum());
    }

    public static void main(String[] args) {
        Album album = new Album();
        Track track = new Track();
        List<Track> trackList = new ArrayList<>();
        track.setLength(23);
        track.setName("I love...");
        trackList.add(track);
        track = new Track();
        track.setName("I hate it...");
        track.setLength(25);
        trackList.add(track);

        album.setTracklist(trackList);
        PrintStat.printTrackLengthStatistics(album);

    }

}

    