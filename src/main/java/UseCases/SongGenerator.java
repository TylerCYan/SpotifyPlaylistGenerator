package UseCases;

import Entities.Song;
import Entities.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public class SongGenerator {
    private String potentialSong;
    private boolean songExistence;
    private String artist;

    public SongGenerator(String potentialSong){
        this.potentialSong = potentialSong;
        this.songExistence = false;
        this.artist = "";
    }

    public void CSVReader(){

        String path = "filename"; // csvFile name goes here
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (this.potentialSong == data[0]) {
                    this.songExistence = true;
                    this.artist = data[1];
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Optional<Entities.Song> generateSong(){
        if(this.songExistence){
            Song song = new Song(this.potentialSong, this.artist);
            Optional<Song> opt = Optional.ofNullable(song);
            return opt;
        }
        return null;
    }

}
