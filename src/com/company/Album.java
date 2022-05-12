package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String artistName;
    private SongList songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
    }


//    public boolean removeSong(String removingSong) {
//        if (findSong(removingSong) != null) {
//            songs.remove(findSong(removingSong));
//            System.out.println("The song " + removingSong + " was removed from the " + this.albumName + " album");
//            return true;
//        } else {
//            System.out.println("The song " + removingSong + " not found in the " + this.albumName + " album");
//            return false;
//        }
//    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        SongList songList = new SongList();
        Song songToadd = songList.findSong(title);
        if (songToadd != null) {
            playList.add(songToadd);
            System.out.println("The song " + title + " was successfully added to your play list.");
            return true;
        } else {
            System.out.println("Your desired song not found.");
            return false;
        }
    }

    public boolean addToPlayList(int track, LinkedList<Song> playList) {
        int index = track - 1;
        SongList songList = new SongList();
        if (index <= songList.songs.size() && index >= 0) {
            Song songToadd = songList.songs.get(index);
            playList.add(songToadd);
            System.out.println("The song " + songToadd.getTitle() + " was successfully added to your play list.");

            return true;
        } else {
            System.out.println("Invalid track number");
            return false;
        }
    }



    class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean addSong(String title, double duration) {
            if (findSong(title) == null) {
                Song newSong = new Song(title, duration);
                songs.add(newSong);
                System.out.println("The song " + title + " was added to the " + Album.this.albumName + " album");
                return true;
            } else {
                System.out.println("The song " + title + " has already been added to the " + Album.this.albumName + " album");
                return false;
            }
        }

        public Song findSong(String searchingSong) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(searchingSong)) {
                    return checkedSong;
                }
            }
            return null;
        }


    }

}
